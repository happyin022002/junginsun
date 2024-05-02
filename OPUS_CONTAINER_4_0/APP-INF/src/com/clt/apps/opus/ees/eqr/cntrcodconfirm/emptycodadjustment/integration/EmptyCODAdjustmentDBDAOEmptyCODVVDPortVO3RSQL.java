/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO3RSQL.java
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

public class EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search cod adjustment
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO3RSQL").append("\n"); 
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
		query.append("		DECODE( VD.N1ST_ETB_YRWK	,	DV.L2,	'1'," ).append("\n"); 
		query.append("										DV.L1,	'2'," ).append("\n"); 
		query.append("										DV.M0,	'3'," ).append("\n"); 
		query.append("										DV.R1,	'4'," ).append("\n"); 
		query.append("										DV.R2,	'5'," ).append("\n"); 
		query.append("											NULL)	weekDivision,		/* WEEK_DIV */" ).append("\n"); 
		query.append("		VD.N1ST_ETB_YRWK week,									/* WEEK		*/" ).append("\n"); 
		query.append("		VD.COD_CFM_STS_CD	div,								/* DIV		*/" ).append("\n"); 
		query.append("		PT.VSL_CD||PT.SKD_VOY_NO||PT.SKD_DIR_CD	vvd,			/* VVD(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) */" ).append("\n"); 
		query.append("		VD.SLAN_CD	lane,										/* LANE		*/" ).append("\n"); 
		query.append("		PT.PORT_CD	pod,										/* POD		*/" ).append("\n"); 
		query.append("		PT.YD_CD	yardcode,										/* YARD CODE	*/" ).append("\n"); 
		query.append("		DECODE(NVL(VD.DIFF_RMK,'N'),'N','N','Y') remarkFlag,			/* REMARK_FLAG	*/" ).append("\n"); 
		query.append("		TO_CHAR(PT.ETB_DT,'YYYYMMDD')	etb,					/* ETB		*/" ).append("\n"); 
		query.append("		WK.PLN_YR||WK.PLN_WK			etbWeek		,				/* ETB_WEEK	*/" ).append("\n"); 
		query.append("		DECODE( WK.PLN_YR||WK.PLN_WK,	DV.L2,	'1'," ).append("\n"); 
		query.append("										DV.L1,	'2'," ).append("\n"); 
		query.append("										DV.M0,	'3'," ).append("\n"); 
		query.append("										DV.R1,	'4'," ).append("\n"); 
		query.append("										DV.R2,	'5'," ).append("\n"); 
		query.append("											NULL)	etbWeekDivision,		/* ETB_WEEK_DIVISION */" ).append("\n"); 
		query.append("		PT.D2_QTY	d2," ).append("\n"); 
		query.append("		PT.D4_QTY	d4," ).append("\n"); 
		query.append("		PT.D5_QTY	d5," ).append("\n"); 
		query.append("		PT.D7_QTY	d7," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		PT.R2_QTY	r2," ).append("\n"); 
		query.append("		PT.R5_QTY	r5," ).append("\n"); 
		query.append("		PT.O2_QTY	o2," ).append("\n"); 
		query.append("		PT.S2_QTY	s2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		PT.O4_QTY	o4," ).append("\n"); 
		query.append("		PT.S4_QTY	s4," ).append("\n"); 
		query.append("		PT.F2_QTY	f2," ).append("\n"); 
		query.append("		PT.A2_QTY	a2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		PT.F4_QTY	f4," ).append("\n"); 
		query.append("		PT.A4_QTY	a4," ).append("\n"); 
		query.append("		PT.F5_QTY	f5," ).append("\n"); 
		query.append("		ROWNUM||PT.VSL_CD||PT.SKD_VOY_NO||PT.SKD_DIR_CD||VD.SLAN_CD||PT.PORT_CD keyid" ).append("\n"); 
		query.append("FROM	EQR_MTY_COD_VVD		VD," ).append("\n"); 
		query.append("		EQR_MTY_COD_PORT	PT," ).append("\n"); 
		query.append("		EQR_WK_PRD			WK," ).append("\n"); 
		query.append("		(		" ).append("\n"); 
		query.append("			SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT  " ).append("\n"); 
		query.append("								LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	L2,                                             " ).append("\n"); 
		query.append("								LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	L1,                                             " ).append("\n"); 
		query.append("								PLN_YR||PLN_WK										        M0," ).append("\n"); 
		query.append("								LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	R1,                                             " ).append("\n"); 
		query.append("								LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	R2                                          " ).append("\n"); 
		query.append("						FROM	EQR_WK_PRD    " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			WHERE	M0	=	@[week]		/* ________________ Parameter Week */" ).append("\n"); 
		query.append("		)					DV," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	DISTINCT SUBSTR(RLANE_CD,1,3) SLAN_CD" ).append("\n"); 
		query.append("			FROM	MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("			WHERE	TRD_CD = 'IAS'" ).append("\n"); 
		query.append("			AND SUB_TRD_CD IN ('IA', 'EM')" ).append("\n"); 
		query.append("			AND		DELT_FLG = 'N'" ).append("\n"); 
		query.append("		)					IL" ).append("\n"); 
		query.append("WHERE	VD.N1ST_ETB_YRWK IN ( DV.L2, DV.L1, DV.M0, DV.R1, DV.R2 )" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'S'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("AND		VD.SLAN_CD			=	IL.SLAN_CD	 /* Only Intra Lane Code */" ).append("\n"); 
		query.append("AND		VD.VSL_CD			=	PT.VSL_CD		" ).append("\n"); 
		query.append("AND		VD.SKD_VOY_NO		=	PT.SKD_VOY_NO	" ).append("\n"); 
		query.append("AND		VD.SKD_DIR_CD		=	PT.SKD_DIR_CD	" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	PT.COD_CFM_DIV_CD	" ).append("\n"); 
		query.append("AND		'D'					=	PT.LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("AND		TO_CHAR(PT.ETB_DT,'YYYYMMDD')	BETWEEN		WK.WK_ST_DT" ).append("\n"); 
		query.append("										AND			WK.WK_END_DT" ).append("\n"); 

	}
}