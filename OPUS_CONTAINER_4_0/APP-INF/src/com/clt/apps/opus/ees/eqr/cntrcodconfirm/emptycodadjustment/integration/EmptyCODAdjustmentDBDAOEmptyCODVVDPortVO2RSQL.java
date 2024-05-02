/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.03.31 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Cod VVD Port List
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO2RSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO2RSQL").append("\n"); 
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
		query.append("#if (${codcfmctscd} == '2' || ${codcfmctscd} == '3') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	/*+ ORDERED USE_NL ( VS VD PT WK DV ) */" ).append("\n"); 
		query.append("		@[weekdivision]		weekDivision	,										/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]				week,										/* WEEK		*/" ).append("\n"); 
		query.append("		VD.COD_CFM_STS_CD	div,								/* DIV		*/" ).append("\n"); 
		query.append("		@[vvd]				vvd,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]				lane,										/* LANE		*/" ).append("\n"); 
		query.append("		NVL(PT.PORT_CD, VS.VPS_PORT_CD) 			pod,			/* POD  */" ).append("\n"); 
		query.append("		NVL(PT.CLPT_IND_SEQ,VS.CLPT_IND_SEQ)        clptindseq," ).append("\n"); 
		query.append("	--	NVL(PT.YD_CD,	VS.YD_CD)					yardcode,		/* YARD CODE */" ).append("\n"); 
		query.append("		VS.YD_CD		yardcode," ).append("\n"); 
		query.append("		@[remarkflag]	remarkFlag,		/* REMARK_FLAG */" ).append("\n"); 
		query.append("	--	TO_CHAR(NVL(PT.ETB_DT,VS.VPS_ETB_DT),'YYYYMMDD')				etb,			/* ETB  */" ).append("\n"); 
		query.append("		DECODE(VS.SKD_CNG_STS_CD,'S','SKIP',TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD'))	etb," ).append("\n"); 
		query.append("	--	TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')				etb,			/* ETB  */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		WK.PLN_YR||WK.PLN_WK						etbWeek  ,		/* ETB_WEEK */" ).append("\n"); 
		query.append("		DECODE	( " ).append("\n"); 
		query.append("					WK.PLN_YR||WK.PLN_WK, DV.L2, '1'," ).append("\n"); 
		query.append("					DV.L1, '2'," ).append("\n"); 
		query.append("					DV.M0, '3'," ).append("\n"); 
		query.append("					DV.R1, '4'," ).append("\n"); 
		query.append("					DV.R2, '5'," ).append("\n"); 
		query.append("					NULL" ).append("\n"); 
		query.append("				)									etbWeekDivision,  /* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("		NVL(PT.D2_QTY,0)	d2," ).append("\n"); 
		query.append("		NVL(PT.D4_QTY,0)	d4," ).append("\n"); 
		query.append("		NVL(PT.D5_QTY,0)	d5," ).append("\n"); 
		query.append("		NVL(PT.D7_QTY,0)	d7," ).append("\n"); 
		query.append("		NVL(PT.R2_QTY,0)	r2," ).append("\n"); 
		query.append("		NVL(PT.R5_QTY,0)	r5," ).append("\n"); 
		query.append("		NVL(PT.R9_QTY,0)	r9," ).append("\n"); 
		query.append("		NVL(PT.O2_QTY,0)	o2," ).append("\n"); 
		query.append("		NVL(PT.S2_QTY,0)	s2," ).append("\n"); 
		query.append("		NVL(PT.O4_QTY,0)	o4," ).append("\n"); 
		query.append("		NVL(PT.S4_QTY,0)	s4," ).append("\n"); 
		query.append("		NVL(PT.O5_QTY,0)	o5," ).append("\n"); 
		query.append("		NVL(PT.F2_QTY,0)	f2," ).append("\n"); 
		query.append("		NVL(PT.A2_QTY,0)	a2," ).append("\n"); 
		query.append("		NVL(PT.F4_QTY,0)	f4," ).append("\n"); 
		query.append("		NVL(PT.A4_QTY,0)	a4," ).append("\n"); 
		query.append("		NVL(PT.F5_QTY,0)	f5," ).append("\n"); 
		query.append("		ROWNUM||@[vvd]||@[lane]||PT.PORT_CD keyid," ).append("\n"); 
		query.append("		@[lane]||@[firstetb]||@[vvd]||LPAD(VS.CLPT_SEQ,5,0) firstetb" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD	VS	," ).append("\n"); 
		query.append("		EQR_MTY_COD_VVD		VD," ).append("\n"); 
		query.append("		EQR_MTY_COD_PORT	PT," ).append("\n"); 
		query.append("		EQR_WK_PRD			WK," ).append("\n"); 
		query.append("		(		" ).append("\n"); 
		query.append("			SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_FFS( EQR_WK_PRD XAK2EQR_WK_PRD ) */" ).append("\n"); 
		query.append("								LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	L2,                                             " ).append("\n"); 
		query.append("								LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	L1,                                             " ).append("\n"); 
		query.append("								PLN_YR||PLN_WK										        M0," ).append("\n"); 
		query.append("								LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	R1,                                             " ).append("\n"); 
		query.append("								LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	R2                                          " ).append("\n"); 
		query.append("						FROM	EQR_WK_PRD    " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			WHERE	M0	=	@[targetweek]		/* ________________ Parameter Week */" ).append("\n"); 
		query.append("		)					DV	" ).append("\n"); 
		query.append("WHERE	VS.VSL_CD			=	SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     VS.CLPT_SEQ         >=   @[dclptsql]" ).append("\n"); 
		query.append("--AND		NVL(VS.SKD_CNG_STS_CD,' ') <> 'S'		/* _____________________________ Skip �� Port�� �� ������� : 2010.05.07 */" ).append("\n"); 
		query.append("AND		VS.VSL_CD		=	VD.VSL_CD         " ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO	=	VD.SKD_VOY_NO     " ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD	=	VD.SKD_DIR_CD     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${codcfmctscd} == '2')" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'S'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#elseif (${codcfmctscd} == '3')" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'B'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		VS.VSL_CD			=	PT.VSL_CD		(+)" ).append("\n"); 
		query.append("AND		VS.SKD_VOY_NO		=	PT.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		VS.SKD_DIR_CD		=	PT.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND		VS.VPS_PORT_CD		=	PT.PORT_CD		(+)" ).append("\n"); 
		query.append("AND     VS.CLPT_IND_SEQ     =   PT.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if     (${codcfmctscd} == '2')" ).append("\n"); 
		query.append("AND		'S'	                =	PT.COD_CFM_DIV_CD     (+)	/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#elseif (${codcfmctscd} == '3')" ).append("\n"); 
		query.append("AND		'B'	                =	PT.COD_CFM_DIV_CD     (+)  /* INTRA */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		'D'					=	PT.LODG_DCHG_DIV_CD   (+)" ).append("\n"); 
		query.append("/* _____________________________ Skip �� Port�� �� ������� : 2010.05.07 */" ).append("\n"); 
		query.append("AND		DECODE(VS.SKD_CNG_STS_CD,'S','SKIP',TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD'))	BETWEEN		WK.WK_ST_DT(+)" ).append("\n"); 
		query.append("																			AND			WK.WK_END_DT(+)" ).append("\n"); 
		query.append("--ORDER BY" ).append("\n"); 
		query.append("--		VS.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		/*+ ORDERED USE_NL ( VD PT VS ) */" ).append("\n"); 
		query.append("		@[weekdivision]		weekDivision	,										/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]				week,										/* WEEK		*/" ).append("\n"); 
		query.append("		VD.COD_CFM_STS_CD	div,								/* DIV		*/" ).append("\n"); 
		query.append("		@[vvd]				vvd,										/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]				lane,										/* LANE		*/" ).append("\n"); 
		query.append("		PT.PORT_CD						pod,				/* POD  */" ).append("\n"); 
		query.append("		PT.CLPT_IND_SEQ					clptindseq," ).append("\n"); 
		query.append("		PT.YD_CD						yardcode,			/* YARD CODE */" ).append("\n"); 
		query.append("		@[remarkflag]	remarkFlag,		/* REMARK_FLAG */" ).append("\n"); 
		query.append("		TO_CHAR(PT.ETB_DT,'YYYYMMDD')						etb,				/* ETB  */" ).append("\n"); 
		query.append("--		NULL							etb,				/* ETB  */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		NULL							etbWeek  ,			/* ETB_WEEK */" ).append("\n"); 
		query.append("		NULL							etbWeekDivision,	/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		NVL(PT.D2_QTY,0) d2," ).append("\n"); 
		query.append("		NVL(PT.D4_QTY,0) d4," ).append("\n"); 
		query.append("		NVL(PT.D5_QTY,0) d5," ).append("\n"); 
		query.append("		NVL(PT.D7_QTY,0) d7," ).append("\n"); 
		query.append("		NVL(PT.R2_QTY,0) r2," ).append("\n"); 
		query.append("		NVL(PT.R5_QTY,0) r5," ).append("\n"); 
		query.append("		NVL(PT.R9_QTY,0) r9," ).append("\n"); 
		query.append("		NVL(PT.O2_QTY,0) o2," ).append("\n"); 
		query.append("		NVL(PT.S2_QTY,0) s2," ).append("\n"); 
		query.append("		NVL(PT.O4_QTY,0) o4," ).append("\n"); 
		query.append("		NVL(PT.S4_QTY,0) s4," ).append("\n"); 
		query.append("		NVL(PT.O5_QTY,0) o5," ).append("\n"); 
		query.append("		NVL(PT.F2_QTY,0) f2," ).append("\n"); 
		query.append("		NVL(PT.A2_QTY,0) a2," ).append("\n"); 
		query.append("		NVL(PT.F4_QTY,0) f4," ).append("\n"); 
		query.append("		NVL(PT.A4_QTY,0) a4," ).append("\n"); 
		query.append("		NVL(PT.F5_QTY,0) f5," ).append("\n"); 
		query.append("		ROWNUM||@[vvd]||@[lane]||PT.PORT_CD keyid," ).append("\n"); 
		query.append("		@[lane]||@[firstetb]||@[vvd]||(TO_CHAR(VS.VPS_ETB_DT,'YYYYMMDD')) firstetb" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("		EQR_MTY_COD_VVD		VD," ).append("\n"); 
		query.append("		EQR_MTY_COD_PORT	PT," ).append("\n"); 
		query.append("		VSK_VSL_PORT_SKD	VS " ).append("\n"); 
		query.append("WHERE	VD.VSL_CD			=	SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND		VD.SKD_VOY_NO		=	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		VD.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${codcfmctscd} == '2')" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'S'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#elseif (${codcfmctscd} == '3')" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'B'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VD.VSL_CD			=	PT.VSL_CD		" ).append("\n"); 
		query.append("AND		VD.SKD_VOY_NO		=	PT.SKD_VOY_NO	" ).append("\n"); 
		query.append("AND		VD.SKD_DIR_CD		=	PT.SKD_DIR_CD	" ).append("\n"); 
		query.append("#if     (${codcfmctscd} == '2')" ).append("\n"); 
		query.append("AND		'S'	                =	PT.COD_CFM_DIV_CD     (+)	/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("#elseif (${codcfmctscd} == '3')" ).append("\n"); 
		query.append("AND		'B'	                =	PT.COD_CFM_DIV_CD     (+)  /* INTRA */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		'D'					=	PT.LODG_DCHG_DIV_CD   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		PT.VSL_CD			=	VS.VSL_CD		(+)" ).append("\n"); 
		query.append("AND		PT.SKD_VOY_NO		=	VS.SKD_VOY_NO	(+)" ).append("\n"); 
		query.append("AND		PT.SKD_DIR_CD		=	VS.SKD_DIR_CD	(+)" ).append("\n"); 
		query.append("AND		PT.PORT_CD			=	VS.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("AND     PT.CLPT_IND_SEQ     =   VS.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VS.VPS_PORT_CD	IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT	/*+ ORDERED USE_NL( VD PT WK DV )  */" ).append("\n"); 
		query.append("		@[weekdivision]		weekDivision ,	/* WEEK_DIV */" ).append("\n"); 
		query.append("		@[week]				week,			/* WEEK  */" ).append("\n"); 
		query.append("		VD.COD_CFM_STS_CD	div,			/* DIV  */" ).append("\n"); 
		query.append("		@[vvd]				vvd,			/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		@[lane]				lane,			/* LANE  */" ).append("\n"); 
		query.append("		PT.PORT_CD			pod,			/* POD  */" ).append("\n"); 
		query.append("		PT.CLPT_IND_SEQ     clptindseq," ).append("\n"); 
		query.append("		PT.YD_CD			yardcode,		/* YARD CODE */" ).append("\n"); 
		query.append("		@[remarkflag] 		remarkFlag,   /* REMARK_FLAG */" ).append("\n"); 
		query.append("		TO_CHAR(PT.ETB_DT,'YYYYMMDD') etb,	/* ETB  */" ).append("\n"); 
		query.append("		WK.PLN_YR||WK.PLN_WK   etbWeek  ,	/* ETB_WEEK */" ).append("\n"); 
		query.append("		DECODE	( " ).append("\n"); 
		query.append("					WK.PLN_YR||WK.PLN_WK, DV.L2, '1'," ).append("\n"); 
		query.append("					DV.L1, '2'," ).append("\n"); 
		query.append("					DV.M0, '3'," ).append("\n"); 
		query.append("					DV.R1, '4'," ).append("\n"); 
		query.append("					DV.R2, '5'," ).append("\n"); 
		query.append("					NULL" ).append("\n"); 
		query.append("				) etbWeekDivision,			/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("		PT.D2_QTY d2," ).append("\n"); 
		query.append("		PT.D4_QTY d4," ).append("\n"); 
		query.append("		PT.D5_QTY d5," ).append("\n"); 
		query.append("		PT.D7_QTY d7," ).append("\n"); 
		query.append("		PT.R2_QTY r2," ).append("\n"); 
		query.append("		PT.R5_QTY r5," ).append("\n"); 
		query.append("		PT.R9_QTY r9," ).append("\n"); 
		query.append("		PT.O2_QTY o2," ).append("\n"); 
		query.append("		PT.S2_QTY s2," ).append("\n"); 
		query.append("		PT.O4_QTY o4," ).append("\n"); 
		query.append("		PT.S4_QTY s4," ).append("\n"); 
		query.append("		PT.O5_QTY o5," ).append("\n"); 
		query.append("		PT.F2_QTY f2," ).append("\n"); 
		query.append("		PT.A2_QTY a2," ).append("\n"); 
		query.append("		PT.F4_QTY f4," ).append("\n"); 
		query.append("		PT.A4_QTY a4," ).append("\n"); 
		query.append("		PT.F5_QTY f5," ).append("\n"); 
		query.append("		ROWNUM||@[vvd]||@[lane]||PT.PORT_CD keyid," ).append("\n"); 
		query.append("		@[lane]||@[firstetb]||@[vvd]||TO_CHAR(PT.ETB_DT,'YYYYMMDD') firstetb" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("		EQR_MTY_COD_VVD  VD," ).append("\n"); 
		query.append("		EQR_MTY_COD_PORT PT," ).append("\n"); 
		query.append("		EQR_WK_PRD   WK," ).append("\n"); 
		query.append("		(  " ).append("\n"); 
		query.append("			SELECT L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("					SELECT  /*+ INDEX_FFS( EQR_WK_PRD XAK2EQR_WK_PRD ) */" ).append("\n"); 
		query.append("							LAG(PLN_YR||PLN_WK,2)  OVER (ORDER BY PLN_YR,PLN_WK) L2,                                             " ).append("\n"); 
		query.append("							LAG(PLN_YR||PLN_WK,1)  OVER (ORDER BY PLN_YR,PLN_WK) L1,                                             " ).append("\n"); 
		query.append("							PLN_YR||PLN_WK                  M0," ).append("\n"); 
		query.append("							LEAD(PLN_YR||PLN_WK,1)  OVER (ORDER BY PLN_YR,PLN_WK) R1,                                             " ).append("\n"); 
		query.append("							LEAD(PLN_YR||PLN_WK,2)  OVER (ORDER BY PLN_YR,PLN_WK) R2                                          " ).append("\n"); 
		query.append("					FROM	EQR_WK_PRD    " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			WHERE M0 = @[targetweek]  /* ________________ Parameter Week */" ).append("\n"); 
		query.append("		)     DV  " ).append("\n"); 
		query.append("WHERE	VD.VSL_CD			= SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND		VD.SKD_VOY_NO		= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		VD.SKD_DIR_CD		= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	= 'S'   /* SIMULATION DIVISION */" ).append("\n"); 
		query.append("AND		VD.VSL_CD			= PT.VSL_CD  " ).append("\n"); 
		query.append("AND		VD.SKD_VOY_NO		= PT.SKD_VOY_NO " ).append("\n"); 
		query.append("AND		VD.SKD_DIR_CD		= PT.SKD_DIR_CD " ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	= PT.COD_CFM_DIV_CD " ).append("\n"); 
		query.append("AND		'D'					= PT.LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("AND		TO_CHAR(PT.ETB_DT,'YYYYMMDD')	BETWEEN		WK.WK_ST_DT	(+)" ).append("\n"); 
		query.append("										AND			WK.WK_END_DT(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}