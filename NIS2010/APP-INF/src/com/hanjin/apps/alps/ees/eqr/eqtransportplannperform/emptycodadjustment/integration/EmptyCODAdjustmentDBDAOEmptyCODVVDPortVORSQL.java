/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * 
	  * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
	  * 2012.10.31 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("firstetb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dclptsql",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remarkflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("weekdivision",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT	" ).append("\n"); 
		query.append("       -- /*+ ORDERED USE_NL (VS BP CT) " ).append("\n"); 
		query.append("       --     INDEX( BP XPKOPF_BAY_PLN_LDIS )" ).append("\n"); 
		query.append("       --     INDEX ( VS XPKVSK_VSL_PORT_SKD )  */" ).append("\n"); 
		query.append("		@[weekdivision]	weekDivision		,										/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]	week,										/* WEEK		*/" ).append("\n"); 
		query.append("		@[div]	div		,										/* DIV		*/" ).append("\n"); 
		query.append("		@[vvd]	vvd,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]	lane	,										/* LANE		*/" ).append("\n"); 
		query.append("        VS.VPS_PORT_CD	     pod,										/* POD		*/" ).append("\n"); 
		query.append("		VS.CLPT_IND_SEQ      clptindseq," ).append("\n"); 
		query.append("        VS.YD_CD	         yardcode,										/* Yard Code	*/" ).append("\n"); 
		query.append("        VS.CLPT_SEQ          clpt_seq,   " ).append("\n"); 
		query.append("        @[remarkflag]	remarkFlag		,										/* REMARK_FLAG	*/" ).append("\n"); 
		query.append("      --  TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')	etb,				/* ETB		*/" ).append("\n"); 
		query.append("        DECODE(VS.SKD_CNG_STS_CD,'S','SKIP',TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD'))	etb," ).append("\n"); 
		query.append("		WK.PLN_YR||WK.PLN_WK				etbWeek,				/* ETB_WEEK	*/" ).append("\n"); 
		query.append("        DECODE( WK.PLN_YR||WK.PLN_WK,	DV.L2,	'1'," ).append("\n"); 
		query.append("        DV.L1,	'2'," ).append("\n"); 
		query.append("        DV.M0,	'3', " ).append("\n"); 
		query.append("        DV.R1,	'4'," ).append("\n"); 
		query.append("        DV.R2,	'5'," ).append("\n"); 
		query.append("        NULL)                etbWeekDivision	,		/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'D2',1,0))	d2," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'D4',1,0))	d4," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'D5',1,0))	d5," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'D7',1,0))	d7," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'R2',1,0))	r2," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'R5',1,0))	r5," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'R9',1,0))	r9," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'O2',1,0))	o2," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'S2',1,0))	s2," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'O4',1,0))	o4," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'S4',1,0))	s4," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'F2',1,0))	f2," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'A2',1,0))	a2," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'F4',1,0))	f4," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'A4',1,0))	a4," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'F5',1,0))	f5," ).append("\n"); 
		query.append("        SUM(DECODE(BP.CNTR_TPSZ_CD,'O5',1,0))	o5," ).append("\n"); 
		query.append("		MAX(ROWNUM)||@[vvd]||@[lane]||VS.VPS_PORT_CD keyid," ).append("\n"); 
		query.append("		@[lane]||@[firstetb]||@[vvd]||LPAD(VS.CLPT_SEQ,5,0) firstetb" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("            FROM	(" ).append("\n"); 
		query.append("                        SELECT	/*+ INDEX_FFS( EQR_WK_PRD XAK2EQR_WK_PRD ) */" ).append("\n"); 
		query.append("                                LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	L2," ).append("\n"); 
		query.append("                                LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	L1," ).append("\n"); 
		query.append("                                PLN_YR||PLN_WK										        M0," ).append("\n"); 
		query.append("                                LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	R1," ).append("\n"); 
		query.append("                                LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	R2" ).append("\n"); 
		query.append("                        FROM	EQR_WK_PRD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE	M0	=	@[targetweek]		/* ________________ Parameter Week */" ).append("\n"); 
		query.append("        )					DV," ).append("\n"); 
		query.append(" --       OPF_BAY_PLN_LDIS	BP," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	B.VSL_CD			VSL_CD		," ).append("\n"); 
		query.append("					B.SKD_VOY_NO		SKD_VOY_NO	," ).append("\n"); 
		query.append("					B.SKD_DIR_CD		SKD_DIR_CD	," ).append("\n"); 
		query.append("					B.POD_CD			POD_CD		," ).append("\n"); 
		query.append("			--		'1'					CLPT_IND_SEQ,		/* Always mapping to first port yard */" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX( V XPKVSK_VSL_PORT_SKD ) */" ).append("\n"); 
		query.append("								NVL(MAX(V.CLPT_IND_SEQ),1)" ).append("\n"); 
		query.append("						--		V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("						FROM    VSK_VSL_PORT_SKD    V" ).append("\n"); 
		query.append("						WHERE	V.VSL_CD		=	B.VSL_CD" ).append("\n"); 
		query.append("						AND		V.SKD_VOY_NO	=	B.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND		V.SKD_DIR_CD	=	B.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND		V.VPS_PORT_CD	=	B.POD_CD" ).append("\n"); 
		query.append("						AND		NVL(V.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("						AND		V.CLPT_SEQ		>=   @[dclptsql]		" ).append("\n"); 
		query.append("						AND		ROWNUM			=	1" ).append("\n"); 
		query.append("					)					CLPT_IND_SEQ," ).append("\n"); 
		query.append("					B.CNTR_TPSZ_CD		CNTR_TPSZ_CD," ).append("\n"); 
		query.append("					B.CNTR_REF_NO		CNTR_REF_NO  " ).append("\n"); 
		query.append("			FROM	OPF_BAY_PLN_LDIS	B" ).append("\n"); 
		query.append("			WHERE	B.VSL_CD			=	SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("			AND		B.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("			AND		B.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("			AND		B.LODG_DCHG_IND_CD	=	'C'" ).append("\n"); 
		query.append("			AND		B.FULL_MTY_CD		=	'E'" ).append("\n"); 
		query.append("			AND		B.CRR_CD			=	'SML'" ).append("\n"); 
		query.append("		)					BP," ).append("\n"); 
		query.append("        MST_CONTAINER		CT," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD	VS," ).append("\n"); 
		query.append("        EQR_WK_PRD			WK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	VS.VSL_CD			=	SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     VS.CLPT_SEQ         >=   @[dclptsql]				/* Asis First Port Seq */" ).append("\n"); 
		query.append("--AND		NVL(VS.SKD_CNG_STS_CD,' ') <> 'S'				/* _____________________________ Skip 된 Port도 다 보여줌 : 2010.05.07 */" ).append("\n"); 
		query.append("AND		VS.VSL_CD			=	BP.VSL_CD		(+)" ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO		=	BP.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD		=	BP.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND		VS.VPS_PORT_CD		=	BP.POD_CD	    (+)" ).append("\n"); 
		query.append("AND     VS.CLPT_IND_SEQ     =   BP.CLPT_IND_SEQ (+) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND		'C'                 =   BP.LODG_DCHG_IND_CD	(+)" ).append("\n"); 
		query.append("--AND		'E'                 =   BP.FULL_MTY_CD		(+)" ).append("\n"); 
		query.append("--AND		'HJS'               =   BP.CRR_CD			(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		CT.CNTR_NO		(+)    =	BP.CNTR_REF_NO  " ).append("\n"); 
		query.append("AND		CT.LSTM_CD		(+)	<>	'SH'" ).append("\n"); 
		query.append("AND		DECODE(VS.SKD_CNG_STS_CD,'S','SKIP',TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD'))	BETWEEN  	WK.WK_ST_DT	(+)" ).append("\n"); 
		query.append("AND			                                         									WK.WK_END_DT(+)" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("			@[weekdivision]			,										/* WEEK_DIV */" ).append("\n"); 
		query.append("			@[week]	,										/* WEEK		*/" ).append("\n"); 
		query.append("			@[div]			,										/* DIV		*/" ).append("\n"); 
		query.append("			@[vvd]	,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("			@[lane]		,										/* LANE		*/" ).append("\n"); 
		query.append("            VS.VPS_PORT_CD	,										/* POD		*/" ).append("\n"); 
		query.append("			VS.CLPT_IND_SEQ," ).append("\n"); 
		query.append("            VS.YD_CD	,										/* Yard Code	*/" ).append("\n"); 
		query.append("            VS.CLPT_SEQ ," ).append("\n"); 
		query.append("            @[remarkflag]			,										/* REMARK_FLAG	*/" ).append("\n"); 
		query.append("           -- TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')	,				/* ETB		*/" ).append("\n"); 
		query.append("			DECODE(VS.SKD_CNG_STS_CD,'S','SKIP',TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD'))," ).append("\n"); 
		query.append("            WK.PLN_YR||WK.PLN_WK				,				/* ETB_WEEK	*/" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            DECODE( WK.PLN_YR||WK.PLN_WK,	DV.L2,	'1'," ).append("\n"); 
		query.append("            DV.L1,	'2'," ).append("\n"); 
		query.append("            DV.M0,	'3'," ).append("\n"); 
		query.append("            DV.R1,	'4'," ).append("\n"); 
		query.append("            DV.R2,	'5'," ).append("\n"); 
		query.append("            NULL)			/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        /*+ ORDERED USE_NL (VS BP CT) " ).append("\n"); 
		query.append("        INDEX( BP XPKOPF_BAY_PLN_LDIS )" ).append("\n"); 
		query.append("        INDEX ( VS XPKVSK_VSL_PORT_SKD )  */" ).append("\n"); 
		query.append("		@[weekdivision]	weekDivision		,										/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]	week,										/* WEEK		*/" ).append("\n"); 
		query.append("		@[div]	div		,										/* DIV		*/" ).append("\n"); 
		query.append("		@[vvd]	vvd,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]	lane	,										/* LANE		*/" ).append("\n"); 
		query.append("        BPP.POD_CD	         pod            ,										/* POD		*/" ).append("\n"); 
		query.append("		'0'                  clptindseq     ," ).append("\n"); 
		query.append("        NULL	             yardcode       ,										/* Yard Code	*/" ).append("\n"); 
		query.append("        NULL                 clpt_seq       ,   " ).append("\n"); 
		query.append("        NULL	             remarkFlag		,										/* REMARK_FLAG	*/" ).append("\n"); 
		query.append("        NULL	             etb            ,				/* ETB		*/" ).append("\n"); 
		query.append("        NULL				 etbWeek        ,				/* ETB_WEEK	*/" ).append("\n"); 
		query.append("        NULL                 etbWeekDivision,		/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'D2',1,0))	d2," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'D4',1,0))	d4," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'D5',1,0))	d5," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'D7',1,0))	d7," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'R2',1,0))	r2," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'R5',1,0))	r5," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'R9',1,0))	r9," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'O2',1,0))	o2," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'S2',1,0))	s2," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'O4',1,0))	o4," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'S4',1,0))	s4," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'F2',1,0))	f2," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'A2',1,0))	a2," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'F4',1,0))	f4," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'A4',1,0))	a4," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'F5',1,0))	f5," ).append("\n"); 
		query.append("        SUM(DECODE(BPP.CNTR_TPSZ_CD,'O5',1,0))	o5," ).append("\n"); 
		query.append("		MAX(ROWNUM)||@[vvd]||@[lane]||VSS.VPS_PORT_CD keyid," ).append("\n"); 
		query.append("		@[lane]||@[firstetb]||@[vvd]||TO_CHAR(VSS.VPS_ETB_DT,'YYYYMMDD') firstetb" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("FROM    OPF_BAY_PLN_LDIS    BPP," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD    VSS," ).append("\n"); 
		query.append("        MST_CONTAINER		CTT" ).append("\n"); 
		query.append("WHERE   BPP.VSL_CD		        =   SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND		BPP.SKD_VOY_NO		   =	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		BPP.SKD_DIR_CD		   =	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND		BPP.LODG_DCHG_IND_CD   =   'C'   " ).append("\n"); 
		query.append("AND		BPP.FULL_MTY_CD        =   'E'" ).append("\n"); 
		query.append("AND		BPP.CRR_CD             =   'SML'" ).append("\n"); 
		query.append("AND		BPP.VSL_CD			   =	VSS.VSL_CD		(+)" ).append("\n"); 
		query.append("AND		BPP.SKD_VOY_NO		   =	VSS.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		BPP.SKD_DIR_CD		   =	VSS.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND		BPP.POD_CD		       =	VSS.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("AND     '1'       			   =    VSS.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("AND     VSS.VPS_PORT_CD     IS NULL" ).append("\n"); 
		query.append("--AND		NVL(VSS.SKD_CNG_STS_CD,' ') <> 'S'	/* _____________________________ Skip 된 Port도 다 보여줌 : 2010.05.07 */" ).append("\n"); 
		query.append("AND		BPP.CNTR_REF_NO         =   CTT.CNTR_NO		  " ).append("\n"); 
		query.append("AND		'SH'                   <>   CTT.LSTM_CD		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("		@[weekdivision]			,										/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]	,										/* WEEK		*/" ).append("\n"); 
		query.append("		@[div]			,										/* DIV		*/" ).append("\n"); 
		query.append("		@[vvd]	,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]		,										/* LANE		*/" ).append("\n"); 
		query.append("        BPP.POD_CD,VSS.VPS_PORT_CD,TO_CHAR(VSS.VPS_ETB_DT,'YYYYMMDD')" ).append("\n"); 

	}
}