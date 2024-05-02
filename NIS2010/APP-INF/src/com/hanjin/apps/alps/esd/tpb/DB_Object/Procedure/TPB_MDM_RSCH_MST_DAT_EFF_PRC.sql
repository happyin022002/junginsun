CREATE OR REPLACE PROCEDURE NISADM.TPB_MDM_RSCH_MST_DAT_EFF_PRC

/*******************************************************************************
1. Object Name      : TPB_MDM_RSCH_MST_DAT_EFF_PRC
2. Version          : 1.3
3. Create Date      : 2008.05.14
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : JO TPB CANCEL
                      -------------------------------------------------------
                      DECLARE 
                          p_mst_area_nm VARCHAR2(20); 
                          p_eff_cd VARCHAR2(50); 
                          p_rtn_cd VARCHAR2(50); 
                          p_rtn_desc VARCHAR2(50); 
                      BEGIN 
                          p_mst_area_nm := 'VENDOR';
                          p_eff_cd := NULL;
                          TPB_MDM_RSCH_MST_DAT_EFF_PRC(p_mst_area_nm,p_eff_cd,p_rtn_cd,p_rtn_desc) ; -- 1) 'VENDOR','CUSTOMER'
                          DBMS_OUTPUT.PUT_LINE(p_rtn_cd);
                          DBMS_OUTPUT.PUT_LINE(p_rtn_desc);
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.05.14  Kim Jin-seung     1.0  Created
                      2008.05.21  Kim Jin-seung     1.1  p_eff_cd ','기준 100개까지 split처리
                      2008.05.28  Kim Jin-seung     1.2  SSA 가이드에 의거하여 Delete문 삭제
                      2009.10.30  Jong-Geon Byeon   1.3  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(    
    p_mst_area_nm   IN   VARCHAR2 -- 'VENDOR','CUSTOMER'
    , p_eff_cd      IN   VARCHAR2
    , p_rtn_cd      OUT  VARCHAR2
    , p_rtn_desc    OUT  VARCHAR2
) 
AUTHID CURRENT_USER
IS 

-- ===== DECLARE ==========================================

    --  CURSOR
  
    --  VARIABLES 
    v_biz_area_nm_temp  HJSCOM_MST_DAT_EFF_RSLT.BIZ_AREA_NM%TYPE;
    v_tbl_nm_temp       HJSCOM_MST_DAT_EFF_RSLT.TBL_NM%TYPE;
    v_col_nm_temp       HJSCOM_MST_DAT_EFF_RSLT.COL_NM%TYPE;
    
    v_eff_cd_temp VARCHAR2(4000);
    TYPE V_ARRAY IS VARRAY(100) of VARCHAR2(50); -- EFF_CD들을 활용할 TYPE; 1000 => 100
    cd V_ARRAY := V_ARRAY(); -- EFF_CD들을 담을 변수
    i   NUMBER(4); -- EFF_CD 추출을 위해 사용할 INDEX
    k1   NUMBER(4); -- EFF_CD 추출을 위해 사용할 INDEX    
    k2   NUMBER(4); -- EFF_CD 추출을 위해 사용할 INDEX        

  
    --  Exception
--  E_EXCEPTION    EXCEPTION;


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    ----- Initiate varibles 
    p_rtn_cd    :=  'S';
    p_rtn_desc  :=  NULL;

    FOR i IN 1 .. 100 LOOP --- 1000 => 100
        cd.EXTEND;
        cd(i) := NULL;
    END LOOP;
    
    IF p_eff_cd IS NOT NULL THEN
        
        v_eff_cd_temp := REPLACE(REPLACE(p_eff_cd,'''',''),' ','');
        
        -- DBMS_OUTPUT.PUT_LINE(' v_eff_cd_temp : ' || v_eff_cd_temp);
        
        i := 1;
        k1 := 0;
        k2 := 0;
        
        WHILE i <= 100 LOOP --- 1000 => 100
        
    	    k1 := k2; 
            k2 := INSTRB(v_eff_cd_temp,',',k1+1);

            IF k2 = 0 THEN 
                cd(i) := SUBSTRB(v_eff_cd_temp,k1+1);
                -- DBMS_OUTPUT.PUT_LINE(' i : ' || i || ' => ' || k2 || ' / ' || k1 || ' / ' || CD(i));
                i := 9999; 
            ELSE
                cd(i) := SUBSTRB(v_eff_cd_temp,k1+1,k2-k1-1);
                -- DBMS_OUTPUT.PUT_LINE(' i : ' || i || ' => ' || k2 || ' / ' || k1 || ' / ' || CD(i));
                i := i + 1;     
            END IF;

    	END LOOP;
    	
    END IF;
    
    ----- INSERT VENDOR DATA
    IF p_mst_area_nm = 'VENDOR' THEN 
    
        --- FROM TPB_N3RD_PTY_BIL_IF (TPB CANDIDATE)
        v_biz_area_nm_temp := 'TPB CANDIDATE';
        v_tbl_nm_temp := 'TPB_OTS_DTL';
        v_col_nm_temp := 'VENDR_SEQ';
        
        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp,
                 VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT
            FROM TPB_OTS_DTL
           WHERE VNDR_SEQ IS NOT NULL
             AND N3PTY_DELT_TP_CD = 'N'
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND VNDR_SEQ IN (TO_NUMBER(cd(1)),TO_NUMBER(cd(2)),TO_NUMBER(cd(3)),TO_NUMBER(cd(4)),TO_NUMBER(cd(5)),TO_NUMBER(cd(6)),TO_NUMBER(cd(7)),TO_NUMBER(cd(8)),TO_NUMBER(cd(9)),TO_NUMBER(cd(10)),TO_NUMBER(cd(11)),TO_NUMBER(cd(12)),TO_NUMBER(cd(13)),TO_NUMBER(cd(14)),TO_NUMBER(cd(15)),TO_NUMBER(cd(16)),TO_NUMBER(cd(17)),TO_NUMBER(cd(18)),TO_NUMBER(cd(19)),TO_NUMBER(cd(20)),TO_NUMBER(cd(21)),TO_NUMBER(cd(22)),TO_NUMBER(cd(23)),TO_NUMBER(cd(24)),TO_NUMBER(cd(25)),TO_NUMBER(cd(26)),TO_NUMBER(cd(27)),TO_NUMBER(cd(28)),TO_NUMBER(cd(29)),TO_NUMBER(cd(30)),TO_NUMBER(cd(31)),TO_NUMBER(cd(32)),TO_NUMBER(cd(33)),TO_NUMBER(cd(34)),TO_NUMBER(cd(35)),TO_NUMBER(cd(36)),TO_NUMBER(cd(37)),TO_NUMBER(cd(38)),TO_NUMBER(cd(39)),TO_NUMBER(cd(40)),TO_NUMBER(cd(41)),TO_NUMBER(cd(42)),TO_NUMBER(cd(43)),TO_NUMBER(cd(44)),TO_NUMBER(cd(45)),TO_NUMBER(cd(46)),TO_NUMBER(cd(47)),TO_NUMBER(cd(48)),TO_NUMBER(cd(49)),TO_NUMBER(cd(50)),TO_NUMBER(cd(51)),TO_NUMBER(cd(52)),TO_NUMBER(cd(53)),TO_NUMBER(cd(54)),TO_NUMBER(cd(55)),TO_NUMBER(cd(56)),TO_NUMBER(cd(57)),TO_NUMBER(cd(58)),TO_NUMBER(cd(59)),TO_NUMBER(cd(60)),TO_NUMBER(cd(61)),TO_NUMBER(cd(62)),TO_NUMBER(cd(63)),TO_NUMBER(cd(64)),TO_NUMBER(cd(65)),TO_NUMBER(cd(66)),TO_NUMBER(cd(67)),TO_NUMBER(cd(68)),TO_NUMBER(cd(69)),TO_NUMBER(cd(70)),TO_NUMBER(cd(71)),TO_NUMBER(cd(72)),TO_NUMBER(cd(73)),TO_NUMBER(cd(74)),TO_NUMBER(cd(75)),TO_NUMBER(cd(76)),TO_NUMBER(cd(77)),TO_NUMBER(cd(78)),TO_NUMBER(cd(79)),TO_NUMBER(cd(80)),TO_NUMBER(cd(81)),TO_NUMBER(cd(82)),TO_NUMBER(cd(83)),TO_NUMBER(cd(84)),TO_NUMBER(cd(85)),TO_NUMBER(cd(86)),TO_NUMBER(cd(87)),TO_NUMBER(cd(88)),TO_NUMBER(cd(89)),TO_NUMBER(cd(90)),TO_NUMBER(cd(91)),TO_NUMBER(cd(92)),TO_NUMBER(cd(93)),TO_NUMBER(cd(94)),TO_NUMBER(cd(95)),TO_NUMBER(cd(96)),TO_NUMBER(cd(97)),TO_NUMBER(cd(98)),TO_NUMBER(cd(99)),TO_NUMBER(cd(100)) ) ) )
        GROUP BY VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ;

        --- FROM TPB_OUTSTANDING (TPB OUTSTANDING)
        v_biz_area_nm_temp := 'TPB OUTSTANDING';
        v_tbl_nm_temp := 'TPB_OTS_GRP';
        v_col_nm_temp := 'VENDR_SEQ';

        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp, 
                 VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT 
            FROM TPB_OTS_GRP 
           WHERE VNDR_SEQ IS NOT NULL 
             AND N3PTY_DELT_TP_CD = 'N' 
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND VNDR_SEQ IN (TO_NUMBER(cd(1)),TO_NUMBER(cd(2)),TO_NUMBER(cd(3)),TO_NUMBER(cd(4)),TO_NUMBER(cd(5)),TO_NUMBER(cd(6)),TO_NUMBER(cd(7)),TO_NUMBER(cd(8)),TO_NUMBER(cd(9)),TO_NUMBER(cd(10)),TO_NUMBER(cd(11)),TO_NUMBER(cd(12)),TO_NUMBER(cd(13)),TO_NUMBER(cd(14)),TO_NUMBER(cd(15)),TO_NUMBER(cd(16)),TO_NUMBER(cd(17)),TO_NUMBER(cd(18)),TO_NUMBER(cd(19)),TO_NUMBER(cd(20)),TO_NUMBER(cd(21)),TO_NUMBER(cd(22)),TO_NUMBER(cd(23)),TO_NUMBER(cd(24)),TO_NUMBER(cd(25)),TO_NUMBER(cd(26)),TO_NUMBER(cd(27)),TO_NUMBER(cd(28)),TO_NUMBER(cd(29)),TO_NUMBER(cd(30)),TO_NUMBER(cd(31)),TO_NUMBER(cd(32)),TO_NUMBER(cd(33)),TO_NUMBER(cd(34)),TO_NUMBER(cd(35)),TO_NUMBER(cd(36)),TO_NUMBER(cd(37)),TO_NUMBER(cd(38)),TO_NUMBER(cd(39)),TO_NUMBER(cd(40)),TO_NUMBER(cd(41)),TO_NUMBER(cd(42)),TO_NUMBER(cd(43)),TO_NUMBER(cd(44)),TO_NUMBER(cd(45)),TO_NUMBER(cd(46)),TO_NUMBER(cd(47)),TO_NUMBER(cd(48)),TO_NUMBER(cd(49)),TO_NUMBER(cd(50)),TO_NUMBER(cd(51)),TO_NUMBER(cd(52)),TO_NUMBER(cd(53)),TO_NUMBER(cd(54)),TO_NUMBER(cd(55)),TO_NUMBER(cd(56)),TO_NUMBER(cd(57)),TO_NUMBER(cd(58)),TO_NUMBER(cd(59)),TO_NUMBER(cd(60)),TO_NUMBER(cd(61)),TO_NUMBER(cd(62)),TO_NUMBER(cd(63)),TO_NUMBER(cd(64)),TO_NUMBER(cd(65)),TO_NUMBER(cd(66)),TO_NUMBER(cd(67)),TO_NUMBER(cd(68)),TO_NUMBER(cd(69)),TO_NUMBER(cd(70)),TO_NUMBER(cd(71)),TO_NUMBER(cd(72)),TO_NUMBER(cd(73)),TO_NUMBER(cd(74)),TO_NUMBER(cd(75)),TO_NUMBER(cd(76)),TO_NUMBER(cd(77)),TO_NUMBER(cd(78)),TO_NUMBER(cd(79)),TO_NUMBER(cd(80)),TO_NUMBER(cd(81)),TO_NUMBER(cd(82)),TO_NUMBER(cd(83)),TO_NUMBER(cd(84)),TO_NUMBER(cd(85)),TO_NUMBER(cd(86)),TO_NUMBER(cd(87)),TO_NUMBER(cd(88)),TO_NUMBER(cd(89)),TO_NUMBER(cd(90)),TO_NUMBER(cd(91)),TO_NUMBER(cd(92)),TO_NUMBER(cd(93)),TO_NUMBER(cd(94)),TO_NUMBER(cd(95)),TO_NUMBER(cd(96)),TO_NUMBER(cd(97)),TO_NUMBER(cd(98)),TO_NUMBER(cd(99)),TO_NUMBER(cd(100)) ) ) )
        GROUP BY VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ; 

        --- FROM TPB_INV_HDR (TPB INVOICE)
        v_biz_area_nm_temp := 'TPB INVOICE';
        v_tbl_nm_temp := 'TPB_INV_RVIS';
        v_col_nm_temp := 'VENDR_SEQ';

        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp, 
                 VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT 
            FROM TPB_INV_RVIS 
           WHERE VNDR_SEQ IS NOT NULL 
             AND N3PTY_DELT_TP_CD = 'N' 
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND VNDR_SEQ IN (TO_NUMBER(cd(1)),TO_NUMBER(cd(2)),TO_NUMBER(cd(3)),TO_NUMBER(cd(4)),TO_NUMBER(cd(5)),TO_NUMBER(cd(6)),TO_NUMBER(cd(7)),TO_NUMBER(cd(8)),TO_NUMBER(cd(9)),TO_NUMBER(cd(10)),TO_NUMBER(cd(11)),TO_NUMBER(cd(12)),TO_NUMBER(cd(13)),TO_NUMBER(cd(14)),TO_NUMBER(cd(15)),TO_NUMBER(cd(16)),TO_NUMBER(cd(17)),TO_NUMBER(cd(18)),TO_NUMBER(cd(19)),TO_NUMBER(cd(20)),TO_NUMBER(cd(21)),TO_NUMBER(cd(22)),TO_NUMBER(cd(23)),TO_NUMBER(cd(24)),TO_NUMBER(cd(25)),TO_NUMBER(cd(26)),TO_NUMBER(cd(27)),TO_NUMBER(cd(28)),TO_NUMBER(cd(29)),TO_NUMBER(cd(30)),TO_NUMBER(cd(31)),TO_NUMBER(cd(32)),TO_NUMBER(cd(33)),TO_NUMBER(cd(34)),TO_NUMBER(cd(35)),TO_NUMBER(cd(36)),TO_NUMBER(cd(37)),TO_NUMBER(cd(38)),TO_NUMBER(cd(39)),TO_NUMBER(cd(40)),TO_NUMBER(cd(41)),TO_NUMBER(cd(42)),TO_NUMBER(cd(43)),TO_NUMBER(cd(44)),TO_NUMBER(cd(45)),TO_NUMBER(cd(46)),TO_NUMBER(cd(47)),TO_NUMBER(cd(48)),TO_NUMBER(cd(49)),TO_NUMBER(cd(50)),TO_NUMBER(cd(51)),TO_NUMBER(cd(52)),TO_NUMBER(cd(53)),TO_NUMBER(cd(54)),TO_NUMBER(cd(55)),TO_NUMBER(cd(56)),TO_NUMBER(cd(57)),TO_NUMBER(cd(58)),TO_NUMBER(cd(59)),TO_NUMBER(cd(60)),TO_NUMBER(cd(61)),TO_NUMBER(cd(62)),TO_NUMBER(cd(63)),TO_NUMBER(cd(64)),TO_NUMBER(cd(65)),TO_NUMBER(cd(66)),TO_NUMBER(cd(67)),TO_NUMBER(cd(68)),TO_NUMBER(cd(69)),TO_NUMBER(cd(70)),TO_NUMBER(cd(71)),TO_NUMBER(cd(72)),TO_NUMBER(cd(73)),TO_NUMBER(cd(74)),TO_NUMBER(cd(75)),TO_NUMBER(cd(76)),TO_NUMBER(cd(77)),TO_NUMBER(cd(78)),TO_NUMBER(cd(79)),TO_NUMBER(cd(80)),TO_NUMBER(cd(81)),TO_NUMBER(cd(82)),TO_NUMBER(cd(83)),TO_NUMBER(cd(84)),TO_NUMBER(cd(85)),TO_NUMBER(cd(86)),TO_NUMBER(cd(87)),TO_NUMBER(cd(88)),TO_NUMBER(cd(89)),TO_NUMBER(cd(90)),TO_NUMBER(cd(91)),TO_NUMBER(cd(92)),TO_NUMBER(cd(93)),TO_NUMBER(cd(94)),TO_NUMBER(cd(95)),TO_NUMBER(cd(96)),TO_NUMBER(cd(97)),TO_NUMBER(cd(98)),TO_NUMBER(cd(99)),TO_NUMBER(cd(100)) ) ) )
        GROUP BY VNDR_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ; 
    

    ----- INSERT CUSTOMER DATA
    ELSIF p_mst_area_nm = 'CUSTOMER' THEN 

        --- FROM TPB_N3RD_PTY_BIL_IF (TPB CANDIDATE)
        v_biz_area_nm_temp := 'TPB CANDIDATE';
        v_tbl_nm_temp := 'TPB_OTS_DTL';
        v_col_nm_temp := 'CUST_CNT_CD||CUST_SEQ';

        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp, 
                 CUST_CNT_CD||CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT 
            FROM TPB_OTS_DTL 
           WHERE ( CUST_CNT_CD IS NOT NULL AND CUST_SEQ IS NOT NULL )
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND (CUST_CNT_CD, CUST_SEQ) IN ((SUBSTRB(cd(1),1,2),TO_NUMBER(SUBSTRB(cd(1),3))),(SUBSTRB(cd(2),1,2),TO_NUMBER(SUBSTRB(cd(2),3))),(SUBSTRB(cd(3),1,2),TO_NUMBER(SUBSTRB(cd(3),3))),(SUBSTRB(cd(4),1,2),TO_NUMBER(SUBSTRB(cd(4),3))),(SUBSTRB(cd(5),1,2),TO_NUMBER(SUBSTRB(cd(5),3))),(SUBSTRB(cd(6),1,2),TO_NUMBER(SUBSTRB(cd(6),3))),(SUBSTRB(cd(7),1,2),TO_NUMBER(SUBSTRB(cd(7),3))),(SUBSTRB(cd(8),1,2),TO_NUMBER(SUBSTRB(cd(8),3))),(SUBSTRB(cd(9),1,2),TO_NUMBER(SUBSTRB(cd(9),3))),(SUBSTRB(cd(10),1,2),TO_NUMBER(SUBSTRB(cd(10),3))),(SUBSTRB(cd(11),1,2),TO_NUMBER(SUBSTRB(cd(11),3))),(SUBSTRB(cd(12),1,2),TO_NUMBER(SUBSTRB(cd(12),3))),(SUBSTRB(cd(13),1,2),TO_NUMBER(SUBSTRB(cd(13),3))),(SUBSTRB(cd(14),1,2),TO_NUMBER(SUBSTRB(cd(14),3))),(SUBSTRB(cd(15),1,2),TO_NUMBER(SUBSTRB(cd(15),3))),(SUBSTRB(cd(16),1,2),TO_NUMBER(SUBSTRB(cd(16),3))),(SUBSTRB(cd(17),1,2),TO_NUMBER(SUBSTRB(cd(17),3))),(SUBSTRB(cd(18),1,2),TO_NUMBER(SUBSTRB(cd(18),3))),(SUBSTRB(cd(19),1,2),TO_NUMBER(SUBSTRB(cd(19),3))),(SUBSTRB(cd(20),1,2),TO_NUMBER(SUBSTRB(cd(20),3))),(SUBSTRB(cd(21),1,2),TO_NUMBER(SUBSTRB(cd(21),3))),(SUBSTRB(cd(22),1,2),TO_NUMBER(SUBSTRB(cd(22),3))),(SUBSTRB(cd(23),1,2),TO_NUMBER(SUBSTRB(cd(23),3))),(SUBSTRB(cd(24),1,2),TO_NUMBER(SUBSTRB(cd(24),3))),(SUBSTRB(cd(25),1,2),TO_NUMBER(SUBSTRB(cd(25),3))),(SUBSTRB(cd(26),1,2),TO_NUMBER(SUBSTRB(cd(26),3))),(SUBSTRB(cd(27),1,2),TO_NUMBER(SUBSTRB(cd(27),3))),(SUBSTRB(cd(28),1,2),TO_NUMBER(SUBSTRB(cd(28),3))),(SUBSTRB(cd(29),1,2),TO_NUMBER(SUBSTRB(cd(29),3))),(SUBSTRB(cd(30),1,2),TO_NUMBER(SUBSTRB(cd(30),3))),(SUBSTRB(cd(31),1,2),TO_NUMBER(SUBSTRB(cd(31),3))),(SUBSTRB(cd(32),1,2),TO_NUMBER(SUBSTRB(cd(32),3))),(SUBSTRB(cd(33),1,2),TO_NUMBER(SUBSTRB(cd(33),3))),(SUBSTRB(cd(34),1,2),TO_NUMBER(SUBSTRB(cd(34),3))),(SUBSTRB(cd(35),1,2),TO_NUMBER(SUBSTRB(cd(35),3))),(SUBSTRB(cd(36),1,2),TO_NUMBER(SUBSTRB(cd(36),3))),(SUBSTRB(cd(37),1,2),TO_NUMBER(SUBSTRB(cd(37),3))),(SUBSTRB(cd(38),1,2),TO_NUMBER(SUBSTRB(cd(38),3))),(SUBSTRB(cd(39),1,2),TO_NUMBER(SUBSTRB(cd(39),3))),(SUBSTRB(cd(40),1,2),TO_NUMBER(SUBSTRB(cd(40),3))),(SUBSTRB(cd(41),1,2),TO_NUMBER(SUBSTRB(cd(41),3))),(SUBSTRB(cd(42),1,2),TO_NUMBER(SUBSTRB(cd(42),3))),(SUBSTRB(cd(43),1,2),TO_NUMBER(SUBSTRB(cd(43),3))),(SUBSTRB(cd(44),1,2),TO_NUMBER(SUBSTRB(cd(44),3))),(SUBSTRB(cd(45),1,2),TO_NUMBER(SUBSTRB(cd(45),3))),(SUBSTRB(cd(46),1,2),TO_NUMBER(SUBSTRB(cd(46),3))),(SUBSTRB(cd(47),1,2),TO_NUMBER(SUBSTRB(cd(47),3))),(SUBSTRB(cd(48),1,2),TO_NUMBER(SUBSTRB(cd(48),3))),(SUBSTRB(cd(49),1,2),TO_NUMBER(SUBSTRB(cd(49),3))),(SUBSTRB(cd(50),1,2),TO_NUMBER(SUBSTRB(cd(50),3))),(SUBSTRB(cd(51),1,2),TO_NUMBER(SUBSTRB(cd(51),3))),(SUBSTRB(cd(52),1,2),TO_NUMBER(SUBSTRB(cd(52),3))),(SUBSTRB(cd(53),1,2),TO_NUMBER(SUBSTRB(cd(53),3))),(SUBSTRB(cd(54),1,2),TO_NUMBER(SUBSTRB(cd(54),3))),(SUBSTRB(cd(55),1,2),TO_NUMBER(SUBSTRB(cd(55),3))),(SUBSTRB(cd(56),1,2),TO_NUMBER(SUBSTRB(cd(56),3))),(SUBSTRB(cd(57),1,2),TO_NUMBER(SUBSTRB(cd(57),3))),(SUBSTRB(cd(58),1,2),TO_NUMBER(SUBSTRB(cd(58),3))),(SUBSTRB(cd(59),1,2),TO_NUMBER(SUBSTRB(cd(59),3))),(SUBSTRB(cd(60),1,2),TO_NUMBER(SUBSTRB(cd(60),3))),(SUBSTRB(cd(61),1,2),TO_NUMBER(SUBSTRB(cd(61),3))),(SUBSTRB(cd(62),1,2),TO_NUMBER(SUBSTRB(cd(62),3))),(SUBSTRB(cd(63),1,2),TO_NUMBER(SUBSTRB(cd(63),3))),(SUBSTRB(cd(64),1,2),TO_NUMBER(SUBSTRB(cd(64),3))),(SUBSTRB(cd(65),1,2),TO_NUMBER(SUBSTRB(cd(65),3))),(SUBSTRB(cd(66),1,2),TO_NUMBER(SUBSTRB(cd(66),3))),(SUBSTRB(cd(67),1,2),TO_NUMBER(SUBSTRB(cd(67),3))),(SUBSTRB(cd(68),1,2),TO_NUMBER(SUBSTRB(cd(68),3))),(SUBSTRB(cd(69),1,2),TO_NUMBER(SUBSTRB(cd(69),3))),(SUBSTRB(cd(70),1,2),TO_NUMBER(SUBSTRB(cd(70),3))),(SUBSTRB(cd(71),1,2),TO_NUMBER(SUBSTRB(cd(71),3))),(SUBSTRB(cd(72),1,2),TO_NUMBER(SUBSTRB(cd(72),3))),(SUBSTRB(cd(73),1,2),TO_NUMBER(SUBSTRB(cd(73),3))),(SUBSTRB(cd(74),1,2),TO_NUMBER(SUBSTRB(cd(74),3))),(SUBSTRB(cd(75),1,2),TO_NUMBER(SUBSTRB(cd(75),3))),(SUBSTRB(cd(76),1,2),TO_NUMBER(SUBSTRB(cd(76),3))),(SUBSTRB(cd(77),1,2),TO_NUMBER(SUBSTRB(cd(77),3))),(SUBSTRB(cd(78),1,2),TO_NUMBER(SUBSTRB(cd(78),3))),(SUBSTRB(cd(79),1,2),TO_NUMBER(SUBSTRB(cd(79),3))),(SUBSTRB(cd(80),1,2),TO_NUMBER(SUBSTRB(cd(80),3))),(SUBSTRB(cd(81),1,2),TO_NUMBER(SUBSTRB(cd(81),3))),(SUBSTRB(cd(82),1,2),TO_NUMBER(SUBSTRB(cd(82),3))),(SUBSTRB(cd(83),1,2),TO_NUMBER(SUBSTRB(cd(83),3))),(SUBSTRB(cd(84),1,2),TO_NUMBER(SUBSTRB(cd(84),3))),(SUBSTRB(cd(85),1,2),TO_NUMBER(SUBSTRB(cd(85),3))),(SUBSTRB(cd(86),1,2),TO_NUMBER(SUBSTRB(cd(86),3))),(SUBSTRB(cd(87),1,2),TO_NUMBER(SUBSTRB(cd(87),3))),(SUBSTRB(cd(88),1,2),TO_NUMBER(SUBSTRB(cd(88),3))),(SUBSTRB(cd(89),1,2),TO_NUMBER(SUBSTRB(cd(89),3))),(SUBSTRB(cd(90),1,2),TO_NUMBER(SUBSTRB(cd(90),3))),(SUBSTRB(cd(91),1,2),TO_NUMBER(SUBSTRB(cd(91),3))),(SUBSTRB(cd(92),1,2),TO_NUMBER(SUBSTRB(cd(92),3))),(SUBSTRB(cd(93),1,2),TO_NUMBER(SUBSTRB(cd(93),3))),(SUBSTRB(cd(94),1,2),TO_NUMBER(SUBSTRB(cd(94),3))),(SUBSTRB(cd(95),1,2),TO_NUMBER(SUBSTRB(cd(95),3))),(SUBSTRB(cd(96),1,2),TO_NUMBER(SUBSTRB(cd(96),3))),(SUBSTRB(cd(97),1,2),TO_NUMBER(SUBSTRB(cd(97),3))),(SUBSTRB(cd(98),1,2),TO_NUMBER(SUBSTRB(cd(98),3))),(SUBSTRB(cd(99),1,2),TO_NUMBER(SUBSTRB(cd(99),3))),(SUBSTRB(cd(100),1,2),TO_NUMBER(SUBSTRB(cd(100),3)))) ) )
             AND N3PTY_DELT_TP_CD = 'N' 
        GROUP BY CUST_CNT_CD, CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ; 

        --- FROM TPB_OUTSTANDING (TPB OUTSTANDING)
        v_biz_area_nm_temp := 'TPB OUTSTANDING';
        v_tbl_nm_temp := 'TPB_OTS_GRP';
        v_col_nm_temp := 'CUST_CNT_CD||CUST_SEQ';

        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp, 
                 CUST_CNT_CD||CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT 
            FROM TPB_OTS_GRP 
           WHERE ( CUST_CNT_CD IS NOT NULL AND CUST_SEQ IS NOT NULL )
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND (CUST_CNT_CD, CUST_SEQ) IN ((SUBSTRB(cd(1),1,2),TO_NUMBER(SUBSTRB(cd(1),3))),(SUBSTRB(cd(2),1,2),TO_NUMBER(SUBSTRB(cd(2),3))),(SUBSTRB(cd(3),1,2),TO_NUMBER(SUBSTRB(cd(3),3))),(SUBSTRB(cd(4),1,2),TO_NUMBER(SUBSTRB(cd(4),3))),(SUBSTRB(cd(5),1,2),TO_NUMBER(SUBSTRB(cd(5),3))),(SUBSTRB(cd(6),1,2),TO_NUMBER(SUBSTRB(cd(6),3))),(SUBSTRB(cd(7),1,2),TO_NUMBER(SUBSTRB(cd(7),3))),(SUBSTRB(cd(8),1,2),TO_NUMBER(SUBSTRB(cd(8),3))),(SUBSTRB(cd(9),1,2),TO_NUMBER(SUBSTRB(cd(9),3))),(SUBSTRB(cd(10),1,2),TO_NUMBER(SUBSTRB(cd(10),3))),(SUBSTRB(cd(11),1,2),TO_NUMBER(SUBSTRB(cd(11),3))),(SUBSTRB(cd(12),1,2),TO_NUMBER(SUBSTRB(cd(12),3))),(SUBSTRB(cd(13),1,2),TO_NUMBER(SUBSTRB(cd(13),3))),(SUBSTRB(cd(14),1,2),TO_NUMBER(SUBSTRB(cd(14),3))),(SUBSTRB(cd(15),1,2),TO_NUMBER(SUBSTRB(cd(15),3))),(SUBSTRB(cd(16),1,2),TO_NUMBER(SUBSTRB(cd(16),3))),(SUBSTRB(cd(17),1,2),TO_NUMBER(SUBSTRB(cd(17),3))),(SUBSTRB(cd(18),1,2),TO_NUMBER(SUBSTRB(cd(18),3))),(SUBSTRB(cd(19),1,2),TO_NUMBER(SUBSTRB(cd(19),3))),(SUBSTRB(cd(20),1,2),TO_NUMBER(SUBSTRB(cd(20),3))),(SUBSTRB(cd(21),1,2),TO_NUMBER(SUBSTRB(cd(21),3))),(SUBSTRB(cd(22),1,2),TO_NUMBER(SUBSTRB(cd(22),3))),(SUBSTRB(cd(23),1,2),TO_NUMBER(SUBSTRB(cd(23),3))),(SUBSTRB(cd(24),1,2),TO_NUMBER(SUBSTRB(cd(24),3))),(SUBSTRB(cd(25),1,2),TO_NUMBER(SUBSTRB(cd(25),3))),(SUBSTRB(cd(26),1,2),TO_NUMBER(SUBSTRB(cd(26),3))),(SUBSTRB(cd(27),1,2),TO_NUMBER(SUBSTRB(cd(27),3))),(SUBSTRB(cd(28),1,2),TO_NUMBER(SUBSTRB(cd(28),3))),(SUBSTRB(cd(29),1,2),TO_NUMBER(SUBSTRB(cd(29),3))),(SUBSTRB(cd(30),1,2),TO_NUMBER(SUBSTRB(cd(30),3))),(SUBSTRB(cd(31),1,2),TO_NUMBER(SUBSTRB(cd(31),3))),(SUBSTRB(cd(32),1,2),TO_NUMBER(SUBSTRB(cd(32),3))),(SUBSTRB(cd(33),1,2),TO_NUMBER(SUBSTRB(cd(33),3))),(SUBSTRB(cd(34),1,2),TO_NUMBER(SUBSTRB(cd(34),3))),(SUBSTRB(cd(35),1,2),TO_NUMBER(SUBSTRB(cd(35),3))),(SUBSTRB(cd(36),1,2),TO_NUMBER(SUBSTRB(cd(36),3))),(SUBSTRB(cd(37),1,2),TO_NUMBER(SUBSTRB(cd(37),3))),(SUBSTRB(cd(38),1,2),TO_NUMBER(SUBSTRB(cd(38),3))),(SUBSTRB(cd(39),1,2),TO_NUMBER(SUBSTRB(cd(39),3))),(SUBSTRB(cd(40),1,2),TO_NUMBER(SUBSTRB(cd(40),3))),(SUBSTRB(cd(41),1,2),TO_NUMBER(SUBSTRB(cd(41),3))),(SUBSTRB(cd(42),1,2),TO_NUMBER(SUBSTRB(cd(42),3))),(SUBSTRB(cd(43),1,2),TO_NUMBER(SUBSTRB(cd(43),3))),(SUBSTRB(cd(44),1,2),TO_NUMBER(SUBSTRB(cd(44),3))),(SUBSTRB(cd(45),1,2),TO_NUMBER(SUBSTRB(cd(45),3))),(SUBSTRB(cd(46),1,2),TO_NUMBER(SUBSTRB(cd(46),3))),(SUBSTRB(cd(47),1,2),TO_NUMBER(SUBSTRB(cd(47),3))),(SUBSTRB(cd(48),1,2),TO_NUMBER(SUBSTRB(cd(48),3))),(SUBSTRB(cd(49),1,2),TO_NUMBER(SUBSTRB(cd(49),3))),(SUBSTRB(cd(50),1,2),TO_NUMBER(SUBSTRB(cd(50),3))),(SUBSTRB(cd(51),1,2),TO_NUMBER(SUBSTRB(cd(51),3))),(SUBSTRB(cd(52),1,2),TO_NUMBER(SUBSTRB(cd(52),3))),(SUBSTRB(cd(53),1,2),TO_NUMBER(SUBSTRB(cd(53),3))),(SUBSTRB(cd(54),1,2),TO_NUMBER(SUBSTRB(cd(54),3))),(SUBSTRB(cd(55),1,2),TO_NUMBER(SUBSTRB(cd(55),3))),(SUBSTRB(cd(56),1,2),TO_NUMBER(SUBSTRB(cd(56),3))),(SUBSTRB(cd(57),1,2),TO_NUMBER(SUBSTRB(cd(57),3))),(SUBSTRB(cd(58),1,2),TO_NUMBER(SUBSTRB(cd(58),3))),(SUBSTRB(cd(59),1,2),TO_NUMBER(SUBSTRB(cd(59),3))),(SUBSTRB(cd(60),1,2),TO_NUMBER(SUBSTRB(cd(60),3))),(SUBSTRB(cd(61),1,2),TO_NUMBER(SUBSTRB(cd(61),3))),(SUBSTRB(cd(62),1,2),TO_NUMBER(SUBSTRB(cd(62),3))),(SUBSTRB(cd(63),1,2),TO_NUMBER(SUBSTRB(cd(63),3))),(SUBSTRB(cd(64),1,2),TO_NUMBER(SUBSTRB(cd(64),3))),(SUBSTRB(cd(65),1,2),TO_NUMBER(SUBSTRB(cd(65),3))),(SUBSTRB(cd(66),1,2),TO_NUMBER(SUBSTRB(cd(66),3))),(SUBSTRB(cd(67),1,2),TO_NUMBER(SUBSTRB(cd(67),3))),(SUBSTRB(cd(68),1,2),TO_NUMBER(SUBSTRB(cd(68),3))),(SUBSTRB(cd(69),1,2),TO_NUMBER(SUBSTRB(cd(69),3))),(SUBSTRB(cd(70),1,2),TO_NUMBER(SUBSTRB(cd(70),3))),(SUBSTRB(cd(71),1,2),TO_NUMBER(SUBSTRB(cd(71),3))),(SUBSTRB(cd(72),1,2),TO_NUMBER(SUBSTRB(cd(72),3))),(SUBSTRB(cd(73),1,2),TO_NUMBER(SUBSTRB(cd(73),3))),(SUBSTRB(cd(74),1,2),TO_NUMBER(SUBSTRB(cd(74),3))),(SUBSTRB(cd(75),1,2),TO_NUMBER(SUBSTRB(cd(75),3))),(SUBSTRB(cd(76),1,2),TO_NUMBER(SUBSTRB(cd(76),3))),(SUBSTRB(cd(77),1,2),TO_NUMBER(SUBSTRB(cd(77),3))),(SUBSTRB(cd(78),1,2),TO_NUMBER(SUBSTRB(cd(78),3))),(SUBSTRB(cd(79),1,2),TO_NUMBER(SUBSTRB(cd(79),3))),(SUBSTRB(cd(80),1,2),TO_NUMBER(SUBSTRB(cd(80),3))),(SUBSTRB(cd(81),1,2),TO_NUMBER(SUBSTRB(cd(81),3))),(SUBSTRB(cd(82),1,2),TO_NUMBER(SUBSTRB(cd(82),3))),(SUBSTRB(cd(83),1,2),TO_NUMBER(SUBSTRB(cd(83),3))),(SUBSTRB(cd(84),1,2),TO_NUMBER(SUBSTRB(cd(84),3))),(SUBSTRB(cd(85),1,2),TO_NUMBER(SUBSTRB(cd(85),3))),(SUBSTRB(cd(86),1,2),TO_NUMBER(SUBSTRB(cd(86),3))),(SUBSTRB(cd(87),1,2),TO_NUMBER(SUBSTRB(cd(87),3))),(SUBSTRB(cd(88),1,2),TO_NUMBER(SUBSTRB(cd(88),3))),(SUBSTRB(cd(89),1,2),TO_NUMBER(SUBSTRB(cd(89),3))),(SUBSTRB(cd(90),1,2),TO_NUMBER(SUBSTRB(cd(90),3))),(SUBSTRB(cd(91),1,2),TO_NUMBER(SUBSTRB(cd(91),3))),(SUBSTRB(cd(92),1,2),TO_NUMBER(SUBSTRB(cd(92),3))),(SUBSTRB(cd(93),1,2),TO_NUMBER(SUBSTRB(cd(93),3))),(SUBSTRB(cd(94),1,2),TO_NUMBER(SUBSTRB(cd(94),3))),(SUBSTRB(cd(95),1,2),TO_NUMBER(SUBSTRB(cd(95),3))),(SUBSTRB(cd(96),1,2),TO_NUMBER(SUBSTRB(cd(96),3))),(SUBSTRB(cd(97),1,2),TO_NUMBER(SUBSTRB(cd(97),3))),(SUBSTRB(cd(98),1,2),TO_NUMBER(SUBSTRB(cd(98),3))),(SUBSTRB(cd(99),1,2),TO_NUMBER(SUBSTRB(cd(99),3))),(SUBSTRB(cd(100),1,2),TO_NUMBER(SUBSTRB(cd(100),3)))) ) )
             AND N3PTY_DELT_TP_CD = 'N' 
        GROUP BY CUST_CNT_CD, CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ; 


        --- FROM TPB_INV_HDR (TPB INVOICE)
        v_biz_area_nm_temp := 'TPB INVOICE';
        v_tbl_nm_temp := 'TPB_INV_RVIS';
        v_col_nm_temp := 'CUST_CNT_CD||CUST_SEQ';

        INSERT INTO HJSCOM_MST_DAT_EFF_RSLT 
            ( MST_AREA_NM, BIZ_AREA_NM, TBL_NM, COL_NM, COL_VAL, TJ_YRMON, ROW_KNT )
          SELECT p_mst_area_nm, v_biz_area_nm_temp, v_tbl_nm_temp, v_col_nm_temp, 
                 CUST_CNT_CD||CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM') TJ_DT, COUNT(*) CNT 
            FROM TPB_INV_RVIS 
           WHERE ( CUST_CNT_CD IS NOT NULL AND CUST_SEQ IS NOT NULL )
             AND ( ( p_eff_cd IS NULL ) OR ( p_eff_cd IS NOT NULL AND (CUST_CNT_CD, CUST_SEQ) IN ((SUBSTRB(cd(1),1,2),TO_NUMBER(SUBSTRB(cd(1),3))),(SUBSTRB(cd(2),1,2),TO_NUMBER(SUBSTRB(cd(2),3))),(SUBSTRB(cd(3),1,2),TO_NUMBER(SUBSTRB(cd(3),3))),(SUBSTRB(cd(4),1,2),TO_NUMBER(SUBSTRB(cd(4),3))),(SUBSTRB(cd(5),1,2),TO_NUMBER(SUBSTRB(cd(5),3))),(SUBSTRB(cd(6),1,2),TO_NUMBER(SUBSTRB(cd(6),3))),(SUBSTRB(cd(7),1,2),TO_NUMBER(SUBSTRB(cd(7),3))),(SUBSTRB(cd(8),1,2),TO_NUMBER(SUBSTRB(cd(8),3))),(SUBSTRB(cd(9),1,2),TO_NUMBER(SUBSTRB(cd(9),3))),(SUBSTRB(cd(10),1,2),TO_NUMBER(SUBSTRB(cd(10),3))),(SUBSTRB(cd(11),1,2),TO_NUMBER(SUBSTRB(cd(11),3))),(SUBSTRB(cd(12),1,2),TO_NUMBER(SUBSTRB(cd(12),3))),(SUBSTRB(cd(13),1,2),TO_NUMBER(SUBSTRB(cd(13),3))),(SUBSTRB(cd(14),1,2),TO_NUMBER(SUBSTRB(cd(14),3))),(SUBSTRB(cd(15),1,2),TO_NUMBER(SUBSTRB(cd(15),3))),(SUBSTRB(cd(16),1,2),TO_NUMBER(SUBSTRB(cd(16),3))),(SUBSTRB(cd(17),1,2),TO_NUMBER(SUBSTRB(cd(17),3))),(SUBSTRB(cd(18),1,2),TO_NUMBER(SUBSTRB(cd(18),3))),(SUBSTRB(cd(19),1,2),TO_NUMBER(SUBSTRB(cd(19),3))),(SUBSTRB(cd(20),1,2),TO_NUMBER(SUBSTRB(cd(20),3))),(SUBSTRB(cd(21),1,2),TO_NUMBER(SUBSTRB(cd(21),3))),(SUBSTRB(cd(22),1,2),TO_NUMBER(SUBSTRB(cd(22),3))),(SUBSTRB(cd(23),1,2),TO_NUMBER(SUBSTRB(cd(23),3))),(SUBSTRB(cd(24),1,2),TO_NUMBER(SUBSTRB(cd(24),3))),(SUBSTRB(cd(25),1,2),TO_NUMBER(SUBSTRB(cd(25),3))),(SUBSTRB(cd(26),1,2),TO_NUMBER(SUBSTRB(cd(26),3))),(SUBSTRB(cd(27),1,2),TO_NUMBER(SUBSTRB(cd(27),3))),(SUBSTRB(cd(28),1,2),TO_NUMBER(SUBSTRB(cd(28),3))),(SUBSTRB(cd(29),1,2),TO_NUMBER(SUBSTRB(cd(29),3))),(SUBSTRB(cd(30),1,2),TO_NUMBER(SUBSTRB(cd(30),3))),(SUBSTRB(cd(31),1,2),TO_NUMBER(SUBSTRB(cd(31),3))),(SUBSTRB(cd(32),1,2),TO_NUMBER(SUBSTRB(cd(32),3))),(SUBSTRB(cd(33),1,2),TO_NUMBER(SUBSTRB(cd(33),3))),(SUBSTRB(cd(34),1,2),TO_NUMBER(SUBSTRB(cd(34),3))),(SUBSTRB(cd(35),1,2),TO_NUMBER(SUBSTRB(cd(35),3))),(SUBSTRB(cd(36),1,2),TO_NUMBER(SUBSTRB(cd(36),3))),(SUBSTRB(cd(37),1,2),TO_NUMBER(SUBSTRB(cd(37),3))),(SUBSTRB(cd(38),1,2),TO_NUMBER(SUBSTRB(cd(38),3))),(SUBSTRB(cd(39),1,2),TO_NUMBER(SUBSTRB(cd(39),3))),(SUBSTRB(cd(40),1,2),TO_NUMBER(SUBSTRB(cd(40),3))),(SUBSTRB(cd(41),1,2),TO_NUMBER(SUBSTRB(cd(41),3))),(SUBSTRB(cd(42),1,2),TO_NUMBER(SUBSTRB(cd(42),3))),(SUBSTRB(cd(43),1,2),TO_NUMBER(SUBSTRB(cd(43),3))),(SUBSTRB(cd(44),1,2),TO_NUMBER(SUBSTRB(cd(44),3))),(SUBSTRB(cd(45),1,2),TO_NUMBER(SUBSTRB(cd(45),3))),(SUBSTRB(cd(46),1,2),TO_NUMBER(SUBSTRB(cd(46),3))),(SUBSTRB(cd(47),1,2),TO_NUMBER(SUBSTRB(cd(47),3))),(SUBSTRB(cd(48),1,2),TO_NUMBER(SUBSTRB(cd(48),3))),(SUBSTRB(cd(49),1,2),TO_NUMBER(SUBSTRB(cd(49),3))),(SUBSTRB(cd(50),1,2),TO_NUMBER(SUBSTRB(cd(50),3))),(SUBSTRB(cd(51),1,2),TO_NUMBER(SUBSTRB(cd(51),3))),(SUBSTRB(cd(52),1,2),TO_NUMBER(SUBSTRB(cd(52),3))),(SUBSTRB(cd(53),1,2),TO_NUMBER(SUBSTRB(cd(53),3))),(SUBSTRB(cd(54),1,2),TO_NUMBER(SUBSTRB(cd(54),3))),(SUBSTRB(cd(55),1,2),TO_NUMBER(SUBSTRB(cd(55),3))),(SUBSTRB(cd(56),1,2),TO_NUMBER(SUBSTRB(cd(56),3))),(SUBSTRB(cd(57),1,2),TO_NUMBER(SUBSTRB(cd(57),3))),(SUBSTRB(cd(58),1,2),TO_NUMBER(SUBSTRB(cd(58),3))),(SUBSTRB(cd(59),1,2),TO_NUMBER(SUBSTRB(cd(59),3))),(SUBSTRB(cd(60),1,2),TO_NUMBER(SUBSTRB(cd(60),3))),(SUBSTRB(cd(61),1,2),TO_NUMBER(SUBSTRB(cd(61),3))),(SUBSTRB(cd(62),1,2),TO_NUMBER(SUBSTRB(cd(62),3))),(SUBSTRB(cd(63),1,2),TO_NUMBER(SUBSTRB(cd(63),3))),(SUBSTRB(cd(64),1,2),TO_NUMBER(SUBSTRB(cd(64),3))),(SUBSTRB(cd(65),1,2),TO_NUMBER(SUBSTRB(cd(65),3))),(SUBSTRB(cd(66),1,2),TO_NUMBER(SUBSTRB(cd(66),3))),(SUBSTRB(cd(67),1,2),TO_NUMBER(SUBSTRB(cd(67),3))),(SUBSTRB(cd(68),1,2),TO_NUMBER(SUBSTRB(cd(68),3))),(SUBSTRB(cd(69),1,2),TO_NUMBER(SUBSTRB(cd(69),3))),(SUBSTRB(cd(70),1,2),TO_NUMBER(SUBSTRB(cd(70),3))),(SUBSTRB(cd(71),1,2),TO_NUMBER(SUBSTRB(cd(71),3))),(SUBSTRB(cd(72),1,2),TO_NUMBER(SUBSTRB(cd(72),3))),(SUBSTRB(cd(73),1,2),TO_NUMBER(SUBSTRB(cd(73),3))),(SUBSTRB(cd(74),1,2),TO_NUMBER(SUBSTRB(cd(74),3))),(SUBSTRB(cd(75),1,2),TO_NUMBER(SUBSTRB(cd(75),3))),(SUBSTRB(cd(76),1,2),TO_NUMBER(SUBSTRB(cd(76),3))),(SUBSTRB(cd(77),1,2),TO_NUMBER(SUBSTRB(cd(77),3))),(SUBSTRB(cd(78),1,2),TO_NUMBER(SUBSTRB(cd(78),3))),(SUBSTRB(cd(79),1,2),TO_NUMBER(SUBSTRB(cd(79),3))),(SUBSTRB(cd(80),1,2),TO_NUMBER(SUBSTRB(cd(80),3))),(SUBSTRB(cd(81),1,2),TO_NUMBER(SUBSTRB(cd(81),3))),(SUBSTRB(cd(82),1,2),TO_NUMBER(SUBSTRB(cd(82),3))),(SUBSTRB(cd(83),1,2),TO_NUMBER(SUBSTRB(cd(83),3))),(SUBSTRB(cd(84),1,2),TO_NUMBER(SUBSTRB(cd(84),3))),(SUBSTRB(cd(85),1,2),TO_NUMBER(SUBSTRB(cd(85),3))),(SUBSTRB(cd(86),1,2),TO_NUMBER(SUBSTRB(cd(86),3))),(SUBSTRB(cd(87),1,2),TO_NUMBER(SUBSTRB(cd(87),3))),(SUBSTRB(cd(88),1,2),TO_NUMBER(SUBSTRB(cd(88),3))),(SUBSTRB(cd(89),1,2),TO_NUMBER(SUBSTRB(cd(89),3))),(SUBSTRB(cd(90),1,2),TO_NUMBER(SUBSTRB(cd(90),3))),(SUBSTRB(cd(91),1,2),TO_NUMBER(SUBSTRB(cd(91),3))),(SUBSTRB(cd(92),1,2),TO_NUMBER(SUBSTRB(cd(92),3))),(SUBSTRB(cd(93),1,2),TO_NUMBER(SUBSTRB(cd(93),3))),(SUBSTRB(cd(94),1,2),TO_NUMBER(SUBSTRB(cd(94),3))),(SUBSTRB(cd(95),1,2),TO_NUMBER(SUBSTRB(cd(95),3))),(SUBSTRB(cd(96),1,2),TO_NUMBER(SUBSTRB(cd(96),3))),(SUBSTRB(cd(97),1,2),TO_NUMBER(SUBSTRB(cd(97),3))),(SUBSTRB(cd(98),1,2),TO_NUMBER(SUBSTRB(cd(98),3))),(SUBSTRB(cd(99),1,2),TO_NUMBER(SUBSTRB(cd(99),3))),(SUBSTRB(cd(100),1,2),TO_NUMBER(SUBSTRB(cd(100),3)))) ) )
             AND N3PTY_DELT_TP_CD = 'N' 
        GROUP BY CUST_CNT_CD, CUST_SEQ, TO_CHAR(CRE_DT,'YYYYMM')
        ; 
        
    END IF;     

	cd := NULL;
	v_eff_cd_temp := NULL;

EXCEPTION
    WHEN OTHERS THEN
        p_rtn_cd    :=  'E';
        p_rtn_desc  :=  'Exception error. ==> '||SUBSTR(TO_CHAR(SQLERRM),3970);
        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;