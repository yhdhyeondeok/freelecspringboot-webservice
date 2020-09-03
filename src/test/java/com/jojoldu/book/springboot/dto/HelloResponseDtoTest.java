package com.jojoldu.book.springboot.dto;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {

        //given
        String name = "Test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //assertj 라는 테스트 검증 라이브러리의 검증 메소드입니다
        //검증하고 싶은 대상을 메소드 인자로 받습니다
        //메소드 체이닝이 지원되어 isEquaLTo 와 같이 메소드를 이어서 사용할 수 있습니다.
        //isEqualTo 는 assertj 의 동등 비교 메소드입니다
        //assertThat 에 있는 값과 isEquaLTo의 값을 비교해서 같을 때만 성공입니다
        assertThat(dto.getName()).isEqualTo(name); // GD, GD
        assertThat(dto.getAmount()).isEqualTo(amount);

    }


}
