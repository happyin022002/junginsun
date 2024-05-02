/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDVO3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.09
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.07.09 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDVO3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IAS  VVD 조회
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDVO3RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDVO3RSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("DECODE( VD.N1ST_ETB_YRWK	,	DV.L2,	'1'," ).append("\n"); 
		query.append("DV.L1,	'2'," ).append("\n"); 
		query.append("DV.M0,	'3'," ).append("\n"); 
		query.append("DV.R1,	'4'," ).append("\n"); 
		query.append("DV.R2,	'5'," ).append("\n"); 
		query.append("NULL) weekDivision	,		/*	WEEK_DIV	*/" ).append("\n"); 
		query.append("VD.N1ST_ETB_YRWK week,									/*	WEEK		*/" ).append("\n"); 
		query.append("VD.COD_CFM_STS_CD div				,					/*	DIV			*/" ).append("\n"); 
		query.append("VD.VSL_CD||VD.SKD_VOY_NO||VD.SKD_DIR_CD vvd	 ,		/*	vvd		*/" ).append("\n"); 
		query.append("VD.SLAN_CD	lane,										/*	LANE		*/" ).append("\n"); 
		query.append("DECODE(NVL(VD.DIFF_RMK,'N'),'N','N','Y') remarkFlag,			/*	REMARK_FLAG	*/" ).append("\n"); 
		query.append("VD.DIFF_RMK	 remark										/*	REMARK		*/" ).append("\n"); 
		query.append("FROM	EQR_MTY_COD_VVD		VD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	L2," ).append("\n"); 
		query.append("LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	L1," ).append("\n"); 
		query.append("PLN_YR||PLN_WK										        M0," ).append("\n"); 
		query.append("LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	R1," ).append("\n"); 
		query.append("LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	R2" ).append("\n"); 
		query.append("FROM	EQR_WK_PRD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	M0	=	@[week]		/* ________________ Parameter Week */" ).append("\n"); 
		query.append(")					DV," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	DISTINCT SUBSTR(RLANE_CD,1,3) SLAN_CD" ).append("\n"); 
		query.append("FROM	MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("WHERE	TRD_CD = 'IAS'" ).append("\n"); 
		query.append("AND     SUB_TRD_CD IN ('IA', 'EM')" ).append("\n"); 
		query.append("AND		DELT_FLG = 'N'" ).append("\n"); 
		query.append(")					IL" ).append("\n"); 
		query.append("WHERE	VD.N1ST_ETB_YRWK IN ( DV.L2, DV.L1, DV.M0, DV.R1, DV.R2 )" ).append("\n"); 
		query.append("AND		VD.COD_CFM_DIV_CD	=	'S'			/* SIMULATION DIVISION */" ).append("\n"); 
		query.append("AND		VD.SLAN_CD			=	IL.SLAN_CD	 /* Only Intra Lane Code */" ).append("\n"); 

	}
}