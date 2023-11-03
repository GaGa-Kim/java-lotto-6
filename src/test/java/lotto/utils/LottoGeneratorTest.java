package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = LottoGenerator.generateLotto();
    }

    @Test
    @DisplayName("랜덤 로또 숫자 생성을 테스트 합니다.")
    void generateLotto() {
        assertThat(lottoNumbers).isNotNull();
    }

    @Test
    @DisplayName("생성된 로또 숫자가 범위 안에서 생성되는지 테스트 합니다.")
    void generateLottoInRange() {
        lottoNumbers.forEach(number -> assertThat(number).isBetween(MIN_LOTTO.getValue(), MAX_LOTTO.getValue()));
    }

    @Test
    @DisplayName("생성된 로또 숫자가 오름차순으로 정렬되는지 테스트 합니다.")
    void generateLottoSort() {
        assertThat(lottoNumbers).isSorted();
    }
}