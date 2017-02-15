package com.sunx.common;

import com.sunx.common.encoding.CheckEncoding;
import com.sunx.common.encrypt.MD5;
import com.sunx.common.memory.SystemInfoBean;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * MD5测试类
 *
 * 1 测试任意长度的数据
 * 2 测试同一个字段加密的结果是否相同
 */
public class TestMD5 {

    @Test
    public void test1() {
//        String src = "XMjI3ODcwODY5Ng==";
//        int len = 20;
//
//        String md5 = MD5.md5(src,len);
//        System.out.println(md5);
//
//        System.out.println(MD5.md5(src));

        String str = "GET:/customer/comment/list:1484827085:631l1i1x3fv5vs2dxlj5v8x81jqfs2om";
        System.out.println(MD5.md5(str,32));
    }

    private String str = "AlsO+BGuRuvzlMvu+9uUhpgSaJnnTh5y1bOMOYkws4HyPyoo9vIrj0X/gSs2kbSVZmuq02+ghx/EVuIPc7+q3m8/pudN/fVqv6mphoAwYS3c5jK1Eo6Zj2nw2vtFftzEn4CNJpLKr/SXYBfxMLie7aiM+mz9UPOBFoyNnxoSUuiLcIK7V+kqFnBSwE4bFK3tchgejsr9znSQs89imnsk1bfiVmnf0ohO36au3Aqjf8TXRoCfaklxygLCbRBppfADdjEOERquyDPr+SwOH7NqMssXOgulOVAwP0eD6BFGF/fSvxZCFj4avfFVNkHjnOttlL/+sQzu+fAkxtgwgZzUThWqrYxtSS8+XhaEA4y4Wo39DbtXkG1cdAkXcbbo6TeU8yRaYmdAta7NoJ/ouvpgvE9cupkqTv0EBmOB/T7r8OmO9nIK+UiJqtvOQDf/GEqd0B+wNQy5eV2TZEfSvDgEEEV0oxnMZwnJSyUOTLgcMdVnDTCVsGFm7RT5Dpsa2S3unarkF3BUACGGJpGZXv2FLCnzvpRG6+dcqoYG1WBJXu4iVuO0dZwzkAhE4/ieC+1tMD+qKv8An1jrujk5hhdaUiYOgDrhrNIwkOxwrZPdCmJE7ThJfH1vX7/YO+DCfbYFAtFSdDqKGD3smmHlcTzLlZVi9HyDVsPHej54KfHK5EkB/lCQ013NCbm1OodwAOVbzuC8ULEiMWYAy+fM7tq2oYLd1VMcX6HDefd8FWQP1ZutvtqypowRUT2Zvyvi1KWBbkdkj/DjXiSr7BBC+j5r9W/61rpfzfMcztKWyDwnZrf3Wpbu0Pt9oykYYrkuRAHRwF6wyFsxLP/5UelSRMxTfEHIUaXtkJI8ST3FXQ/fh/iokZUOnWCDA+9oXx5y8xloXscLMQSykLtMKqWlnIwfBTgWJP69o01Z4k7MI2/vWaGZpFUmRFZ5Vr1f748qB3AeNMa2VbBnPkFWxJfIiFh2ZcUyKgHrbNGIv9Pev1mGM2LmBn/u9xrs/DTJBjNGFhFNcWSgxzZq9s4bq1nusRthKLSxLSJ8+GnI4cQ9PFgztqhdqnp2qtxB+bBND9s9/UiNnm0FME1rxuVBqmWAFTvZJloXhUlmqCuc+qfQXXCBKw+kXqXKBcF1QDtSp3JyxtF0xuC73dCu0qIiIextxDf2ggyLsmwQD21fuos79rwVwV2Xm6xqg19VSb+70OShvYmBGLxbXw2VQ+UoV91rqdpOQadee9fJu34IOTvGiYMrHfyje31u2pynCZxrDS/bIFuG4CNY/p8tqke87ZCjg+3wbLGFAQhsHSUwh+HrPCDmKSSCh7VtWCKzHlYb4ABWgaioykl81Qd8L/hozfzBIQswdBo8FFu/XRfj1M+7pWbx0ssBKBL1OlE7nVWZe0JVbUFoLlA64rGHaTcbcFNQP7d8s+KOSQ4hgz8uY9mB5gZNJzsW0nvfkt5VCUVu2X8d4WgzS3qQJNqiPMWYC5/70lmfW42M2jyi9zaab7azZDwYfbhkAlurOKugz5BfeAWHJi5eU5pDLT26AhG3VsfgZeb0cDKnKw5KyfDZkRCH1bF+XhevjN8bS3qSAUhdN7nbwY4anhv/rcqDkIQ+qS2lb/Jlsch7x2a8Lq4O6DoZ0wJyilj2gHOoiRsIrMa3qqydBJkC0yDHign6dS0Wk9biS1ZnouyshKFWXCtXZCPzY+FUbJhgkROkKursR+jAfRTT6VHpHjQA3KorTr+JaHXGL5CktECYTewQrWwFQtYRowj8PqhZ4pW+yQnRCS7SfGzewFEBj2JQ6jZSbRfEA+Ss5IZwK3vqheBv3fTBpeqzVwipFgatwUytUj2BzuacZgqX2zjQRHAL52Z+7X6wVuj8PPalp95HTrfpdq581JlBTgNmWSYX1yOZFCd348N0lNL9OTNNKdemogTTxTNWc1Quui3EOQs+q77n3UBipUsoH3sXSk+UzlXmNuO8AEb9oU8+VxdKTif38BVMdQFR+/CL7EK7BY0Y5yYQSHdqvt+i0Wi7uwZNez5mDraRaPHUyZxe5ey7RA7wwi+3DN6IVsWZkfcJ+88Q08TdehVn6HPcuEZbkfe1xe5JXr2H9LR/DiLpqTpOTn9SGKJUhcVqSbsx3Q6d/2Op2XyKr2wXVPU5KhLzQKix9Ai58FYnFPlbt++jW4GGV0vY78jWZnx9gv2/S9NPEp/klY9IZS+XjTyAFZH3hhoQa0XB4v1PMXWpUmWHAoM209Vb9cwWooMwQfcZo0KwRUhG++nZIlvBfgd6MSkVkz97Bvqbc65nxViDOY3/LYn/miw0oQ8kSKEyMEn8opDVOySn1w0M05CFyD9DbF88JPo6cM9zCQ2rISgCMzbci8tj83Lca9NGUBNN59fUsxPeIpI6VQzk9vx9273libjgWmEOxBS3ZffC2GeXWA7bQlYEIyKbye/X1OjRI+6LIJpwvNDKbR+tudbC4QP2+KFMID5dltP5GYG17zzHy6UJP4hbxakoUc6gU9/+SGqiIySDT2Xlt8qkWhVlA2ruSn/O5xJbK51O22I2umUsxkn+DGRrasWxcPq/WclnaEBDsTrC+bNtXBvNekJEEBBLIgs/iq1gWis+1zIwmiapm+0tXQNe0fw/mMCjJiWfO8w+KljTW2y828/CdUSP8IsLdmlO+tjnDeA4fSucR7B9Wz5IkwW/BHSC4FZI7LMsGD4cP3EVU6A8ltCQxuI2BGOySpSkx+Cg4LJPeLlycY2WO+qGWqP9hFwzUoSobwU+LZlZwHKYMkCis+qJEolVaChejZpG4uUJ2kqG7VnvpUxPHUaVe+g/pobfRYTTd2QwnOE5J43HkEqNQV0Cmin5Ak+tlZ/wl2AS+TLSeylr2ThKyOY0ycwKT5FWtFwhXsX0ghFSOnS7ugNVuJDvZ5OGK1ur8A/xwunNsyazbPcIcHJfra1q0lHZZpZaEADL7eEQnyWOSAeJf+JN+iAoEXoJBeiamUpUewz1Px5c6YfjZLYOs9xqwgOv1xdvN0huo2fRs5Q4aj+26UzOuvTQ9UyDRRwQ8shdjWJw8jPLXBhmJJdBxuyPs6FIUK4VRJEkymMabqxdxV/Sz0Gqu7/IXdfnSmR7p0SEtC1Ol7/FLQ1MYp7HkC63UMCdkTcEHeKwCX91Z6ofsYaWylCC43O2xKLHc630hg2JMIEZN7jWGpsV/v1U8JI5CI91Gb6A3xMhhaw+908vceFLuFU56/QxHy9Mimk3umZ+DqJtk7z3/6Ni8UucMVZOhk5E2w4qDl5deCyNHDu5khEI+1nVwb/FrXmUOG/e6RIGDTsc5I1J1roegOyfO4ITqHV9TYxpZMaV6DyVTAcqoEEevfXKSKO0N3Vj0DOwJ1oSF0gs5R6Lby4jq9OaafyFl8DqA6DC3lvGgFb8ZAS8c63WwPkytbCJyeVetwOVRbZIJPJbbWEUOREFhOa6GU123BlXtrkD05jCaKdNnTMorFMYixPUHdgmcqCLF15nhZ1hWPknc88REzYI4yMDRrVMRenQQMmj/lauH3EMxw96KhVVUTvn1QZZovtGyR7qfnYjkazg4NRTTLQVJUOfVvj47qhp9dGSJTc8d1wC09tT7in1yS06psBKE8kqsPeBPdqKgTOPciETtU4hFYuISLNAvhl2lJ3UjhBlUEd0gU4TuktjbRVGhGnZMudJRDhqmfXzofw2Vzis89mU5tzvhh+EP0wG1CwyIZcgmo3XvIeF798jRWhzTBRGxhvI4PqnR7/GpCZOMEzTuXoPa4RlwTC8q9XVwfNRJfLpGM2RvhaXZydqLS3hm9FlK0gmY4De6uoMds16ATg5gape3XJgbk/TokKX3oFHpKmow3cMv/jyRC5FfPmyeLcBNT5Tc7ldCz+g+tEKAyCwDsVr/XA1ix2yTgB3v9xy3ydXxaEYjHspyMiLNkSJ46afPyCa+EAtaBodc/XI2b7gOmp4dbkJxkVNca9oPGakTLhhfQe7WAJFuxn030nn27lkkCsjntyPo2sgt0ja3UDht6se2FH3M1itSfqoWDx7AFa3wbIyrW861IQNN7G/eKDGoFTA+wFFN3FNfrOcPHDT5YzrxAYaljkDU5itWsOED9Z6F/73V5Uk3Qts7IHoo6Lp+3eNOunh4MSy7pnQqnBmZXoj/3aDYSnjNyq8XDLiTzIxJg+pJtNhbSFFI1DxJPvSILYr61JR1rpw+ZgVEEEpqQT3pFCWHIPoghCcXhrQuFEIrKS+cfKAJIuD82Y5fAi0PRRvIt17KccT6bPeUcug9tyto8gM5dwkCmdh6wkMqDiHQ9d1Xeme8m1STTrZi+R8jQrbxtM4wgYmQGC4iFL+0DWrN3afGRdcv/I2+l/GaQvkLPPofwMJmi7Q+dlGObo+1koBEr8RpM+NdwrLVPBbpVgysZQB3TvjpMhIH992FoJwn25xSXlCi0JhkcGZtOgZ1Lgye45bZAFenYxR+FcjfmCh0hpfz2tbXe0CvAomEryodVY9SHeZZFCbsXe3JH5NtA04vkpg6ebSYCLwvshVAc/ilhPz/ZL5pFkZj3DaRxl2jnLC4RBv3WmLjUjS2+be8c4mlvGQbYbc4Yr+Zta34lORyaQgI2RMviVRG94IFganYxCT15AZMWwfQ5E5mxRyb1UPJh6/FzkcFlYnEsmnDZY+eJROW4vkeErlh/V87wo2sOnxvHVrinfV7S8tHx6RPv/2ToTzhqeEhwujc7VxyLf65PPhv8+U0np1yYGV+89yEkRphK6fQg2owdzwJKCn0/r+EN53uzMZIBYbtGbJupwjg6PtNSUtRs+1REBkV8bIxoJUHnruFfoPgOq4WlTHA3xuEdESNMKyl3/lsALhHBZXFKVYhfAqfDjm4VDZHPUmx96U/9prhFckuL35zXNX65fr2sRox8uxjCzFjRPnh/RdXwJFXYFIsTxguNxDSjSENiQLI0GU1wjDLMInFfVe6KOgksaF8mVGB89WpOZibc3LHH2ujay9tOB+CX6E3dHL5fQfQRH5SBpahCg/KGgp6BEGW7KTcRiiNaEHFkzJevSnjwJNGg7UXH9crycgrZOJfA+NVnS8K4833m/cgov79cmQ+5AqExhIThmNwhkqy3hYHsxCvS/uWgxHFAZo/WQL9X4bB1YUweb3GHtbFyUzXoXRow35hUeeNUOmsrMzbki9+ImEuXuSv0gFsQd7ADy9zkAfvjDeZMqBZ7hYLRR4eWJUPmxQ8/mFM6HSxWtlXue3+SGKb+4PjdzBjGsJB1OaTLkT00SVnJKWSnxV9geM3bt869NwByxQXNzvUKhuytqa5zBA5mZZx2xIX0e2Lm1MysnpU+klbDmbmkF7Kxlld1B8krAon1mZ62yIfje0WTitRzF0yF3Rmk+hwGKqJ6t6M25SrY3fSGlsy+Zst8oDnzvfzNe3IbnspFM5nnSryQGm0wOg+LnpFVLcNZqIkH0R9Xn14c6Ndzr/dB5W1vYq0vIpE65uFl3g6HuHrYLCKkwflAnObJcktFa1LQ4ZL3Dr9+1/fp0mPAE45JCnmd2FCi5Mwm9Bx1c8ZPM5XsTbJD4Ip2fpC/oK6ArM6KBpTMRzbQuM01XS8aJm5aTXuAzEfURqbo6+yZt6pGnM/gbj/Kw4BA/J6NjG/IFgaJKRw34bzlH5SVwX8V7oTcG+Ltjmp/zxc5IWMh5+0NVggzX507zSo3GcQxT899jod6Mg9LGGhcbZFoIG1+OEfXFgA5w9ZDPXf8Z0R4/tIqbJ72V7Zm/bfmoBCfH+sQriCqFlAgfSgAIurL630Q1LDFdyFqaZ69ZS4ypgTBsgIU0P3Gljl9m5uMUAqI28HivGIwQ2XR+dDfs+qT78RdVmazJaVH70KLRvY+71/bEvUe5HvkjNNtmO7XqBAuhwERJQbdAXERg+fzBzrxbOMiDxd2+3F7EDAitX2jK1CnmPjRWXBBLRBjv3gmfjqUyxPvVICEM9DOS8rKYSMW9cWwb7jdPbYIcGu/6uylJotCJ0HvnDRPK5vZ8eSr13vQcfj6f1NnVYL1excnE+C8yBZA00ShXO91wY6MiieFNQSQcsTk8MFYshDqn+uyi9zBQNtjjRTMJDLjn8psPAeUy2A5XJ+qYXT659bejueMqhUpS6BPBdrWpPddhLlvYuDvZ4+oAJEErAYCBEdMpTb43tF9zi48lltDxFIotwsroui8IPt93vzKp4MF9ZfUV4pvcXSfEypfmo3xzHqDY1zr7Q6Z+vjs6KjoH3/IwSKidYqHmTJUrMFiw/WCKxlsu6wObbDLX5VjQ4L8bxRc86GV30x2i1XZjaAyHSt4Nnd7bhgwNAFdBQqK+upz9DsT1Nf1+T4w7SLJuPb/MpoNjpF9maRkGvwtTdlAwFGf4bFA7O1ceqHHMxcU+o8fX5oydSYmGJA1y3V1skpwtWuk9hLnpa4yJU7lDY58Sl7TOSijFWn+vGvf1XjDhDYnMen3tZxtcyIaEfFUGrnmKBI56L0EIuptdCAY6ppkPZDqpsGyhmYyaHqZFuVmJ08tNxLdLtyJ4IDcBeICi9i4GOs+nXLGO5XtoEyvKIdGqXFsB9aZY2bqrgJzmLYNJQxiZZjyMpa22g3+gFmE9XI5YyhB8KvlX9bKFQYY6sOsvkSTNCaYrG9xw15hylCfX9o9U2e74n1PrlNpuOXJgVK/m+91PcQRdJWciSaeUDLyqc7Urbr5uMPwqqq1jCam3QveFvbvoOn8ryCLU6BrFekpEU8nY8jtULmesLPv1MYiS1EqX532TJ4kQ+pjnG30iY/hyDoFaxcvsyeL77JDE2eAtG3rGv0VnNEtTUUKdXXmB0GytNS0vf2K2/LLmSBQhIBn1WIo+GO5XTqjUyjPYmWgsLgDPIb+3GMC94EHzlFcRRgS9r4R0oUWdlNlwa/TRbEo37oAmYTHHz6FU4xR9pcbBepfuCd1OB7ibCwXtb2vYmJUGtgm39ePRZBIo/taC0V/KjFJ8FsBYiiVaTURTNHJHHKjoKnIYtFBgm2JYhtbcZKE1vhl+3Ss/5AT02olWu8p6IFPcv1H0bQCsKVC3rY6eQygVO+S5HWZntrgwsjkvd2Bltt+L6IfT4m/T5DzD8sQ24xzMTErgPeIXyUSXbPFu0Mzt7hSxaAK9Zp9HICBNpOV7h0XxfFYC6mN2k8gLXCyZtJ6Lq6m1jVWXnF7w6JPPb4sBygq/SeZJhoDfPErekf6MVcnGW8h51O8fytGQ03hOJJbhNKPvHjcbyFWFZS9+9Ick2nISglh08dNJuCQPDjs+UL9jf4wADDYgbBXuyz9WY2OVUF8+M+iwEPqFLKijyF2qIr4hEQ/I74HU2tj8mGW+eIRGcivcCy3ToVbFu+W1NTJSe+OIu8yknm4OL/FcaqCqHfZbYZ0eKmp0sujnvKM9TgtDtuDpBoMDtLgVCff5kImYQEW0pvjJial9Kni0hXZu7SoLthHsVPMDKKBKQVKWIkB2SP3LRe3pwKEN6NPWWYp0HeseQQQmgxYX9B3d5CvalmIwdOA3ysYKTz30NGa3l9PXuj5MqVS6mWLoCxvO/kFiXw0RjD6f54k+d3N1pookoQvk0deim2eEha8qyLbqNzrz0ug2wuOe9PAnqlJMJuVmYsGIYZfzsbh/zun5R/WmwScQmqHsEOzosiOh2l8yCbsOztzlVD5P0s4wnOpCsBE2O8d483LgnU5TZNIu12IGOyd9v+nL1JilOL6q6uNr40m0bP2Y3zBGKoSTkNKZP5U69HjwEKVCFR5nhUV9WmWfYpBrzm+gMpFtGEPY4i/zNuv5b2yWlA2fwNwdmbq4cHoYYsHSjHLRBzkC8ZRxH0YaV1Q2bM7nDiea7ByvGW83IXf/PDvYzLpXAEVee2p471qrKv8dzzbydkVwmmm0ZsjL25F+HaYEUI1R6WJCQmx1acp007L/vDcPuQZLsJ3nrSFeaIofo4cQHKTMV5XBgt/L/od9TX+2iLd57ZmxmEqxDHq81IzAj+kELRXOqDkwuF0bJDMcWvYKgl03b0yjonnt9ZAEdQkoTUEcLospeaF7xOdfjf9e0YzLkgP6gyoSOK3YYHAGVQmr4k15doSbj4A3zhl2MxbaDzLwMsBDYZxzkmIae1wrCzmsbH6Ni4vDwqIvWuWbQ9YAUmOKoAFeieHSkIxzJ/Ikjl/LdJbA0krtozzWN/uwvgaWoeFt09U+xhBCun/ma20vcRaNoGKMSdv0H0C3t6ileb+pJ3BlHsSZWLXPjgqhALxCezeanCsB+nM3C3fB2dhxDjKgUdeYZA5H8fV4xC08I0MDYJtFY4P6xxY1ZwCzTGGe0ZSmLGuoTaLSwwj2+/QK6C06sdHCaQBl6q9A5UFqHRBMftrhhcRG8dCfY83v6oLr0fb6nyXE8RbUmFN1KB/ugFm+xG2I7ac2G1T1Wbs/5UYtwprHNKbV0ktQi5NJz7YG6gdQX6afEos23EJqn324ZVzGPjl5b6bXTg+E3yIYAdBslD/0Af5zuuEgkbEN6bF+B12eckFep3/fdbcsK9skP3W1TE6qIadDM1JkMCbi8l7TCS6WQbPabbRSoVzCc5lQJQwQoq1ZayvjvII+rBcKdUxAh4u1R7XQ9QzqIxggHIKQU7PIC0NRFSDkAhBgEHPQKtZf6Lkl4BkLaYIKKgjcoUWvRuIeb0lNObNsxdjMoNFWoONBr0vLMTMadeu9ba5IiTJ0/0bLGvOKUYV/qhTc3wvub8Snh3HfwEYuOgSN8+SHjWGPIvV2EYvnsLAcJ/m0S7vH1tHVVrPKhsSv8qZHhCtDa7QT/clLamIvderkw1nzyqEOicgnmtani8ByO3ibdnJbeFGok1FEy9xDNH4NTjbaREZCL++aiJ/xNdhS93dx82WWW9a30a0S+cHBxNuKGc6/selTfoz3rCTnNLIdubu7PEee1DGi6xU3pL0z2et7UbP+pmGhKH8/FMtpqWo2KPmXACPVggkP1V2fpXtLhWXhfZC7wmMhEellftOwWge/mFa+/DUNcPt5mV56/ZkfZG2XsxspDMkD0omCcNiHiQwdZ7PIen7SvpOT5QYj7K5QRuLgl3GoY6NVebGL/PCS6qi+6WTmVXt6F8qzvZ6qSSsQcUnjsunMi7GfzJ8znsJkr34wki+W6pzGm01/ySve+3HIP/PBlQatm7BAgoZ74MadVZpGK+e/hMfLqudgIMmJPnF6jDiDxaeW7nbgeaM2zFEvgHQikENe3mha0N3urLcQ2A56QDojw8rXewvwxQbC0ti/3CnDkig+/eSfWMSGZjHz3U1clnXc3nlMQmKoO7ZH7gBlhD8Gv3AGUXyo9ynk+lHr+l0KuxI8u9/10MhIlH+9HwnyHMrkQnSTatblNibrMAeffLcB/Iln2N9cDukat3qvYJAS9WvwrfSZN2dgprIA7z0T1eeV+ks1PbQCmMPWde4O/1Dq/7dEUwCdIb8rvoFSoMYFqk+KrEYAIZjclXVtAXIWedItM9bKXi2oCrEICjpz/KjoleLwCxukp+1vLrGud/3OdnhjF27LdMrElBUJxkqROVDt+Eq96fNPcsftInAdgsf+xHJfSPakMWFifrG65ujNU7pqqBB+z4Uu/zT9f5RsLzd/pfBj4VLEUnCo1dfP2CzR10RufTYEo9tqA1Zbvw1fJT2R2YFZAg2UrBWjNYYXZmZZZ88tGK7CcM5X4dNax/mppD+Q8knxcMJqGrpF5FdHOWa/IxRY8MC3H5d4f1ysR0UqoseyQBcM72q7EnCBsedBoxUTM3tCfHqEOoiw0ELXR8aElMnTyhV+JjkB0VrGIpiaz1wirRaRgMNLMHmAobBQYsl5SfrNurlmQJOX8QFr54W8fSxqrfwbTPVYQhDtoss3ER9YIB3jJrgmvh4vrSK/b/QorT83HBi5zuV+nD7OxCqAr9lHipLQ3C9Wv/XHz3x18MJfNvoKCOqTHhvPL22xEwp4v3vx5D1d541KSr1GMkow9YASxu8Dibe/je18PLbAsBIAHA2mm1Kgq5Hqae96BSBtpYIyN8mFTgOLolQxcqJqrzVDLMt5iBc5AqVKpffnCjkzwSehJ2VAldSBQWUMqsp4+MNcTL5SqB7SfWQwQZlGs7NkodFD6ayeQiQVMeyBEh5PrEGoZ2MELti7ug+I61OuNjsDCBTiV4wMIH8Fv1/Or9e0Ce8dN+Zc7+7JnIpVIBI7tMDrYqQZ5pFic9Xw=";
    @Test
    public void test2() throws Exception {
        CheckEncoding checkEncoding = new CheckEncoding();
        byte[] soruce = new BASE64Decoder().decodeBuffer(str);
        String result = new String(soruce,"GBK");
        System.out.println(result);

        String charset = checkEncoding.getEncoding(soruce);
        System.out.println(new String(soruce,charset));
    }
}
