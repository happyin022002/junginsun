/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOEdi323AdjustmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOEdi323AdjustmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception Management 의 시트를 조회
	  * </pre>
	  */
	public PortPairExceptionDBDAOEdi323AdjustmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOEdi323AdjustmentRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		J.CUST_TRD_PRNR_ID		CUST_TRD_PRNR_ID	," ).append("\n"); 
		query.append("		J.ADJ_RGST_DT			ADJ_RGST_DT			," ).append("\n"); 
		query.append("		J.ADJ_SEQ				ADJ_SEQ				," ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		J.POL_CD				POL_CD				," ).append("\n"); 
		query.append("		J.POL_CNT_CD			POL_CNT_CD			," ).append("\n"); 
		query.append("		J.POD_CD				POD_CD				," ).append("\n"); 
		query.append("		J.POD_CNT_CD			POD_CNT_CD			," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	WM_CONCAT(LL.SLAN_CD)	" ).append("\n"); 
		query.append("			FROM	SCE_323_ADJ_LANE	LL" ).append("\n"); 
		query.append("			WHERE	1	=	1" ).append("\n"); 
		query.append("			AND		LL.ADJ_RGST_DT	=	J.ADJ_RGST_DT" ).append("\n"); 
		query.append("			AND		LL.ADJ_SEQ		=	J.ADJ_SEQ" ).append("\n"); 
		query.append("			AND		LL.DELT_FLG		=	'N'" ).append("\n"); 
		query.append("			GROUP BY" ).append("\n"); 
		query.append("					LL.ADJ_RGST_DT,	LL.ADJ_SEQ" ).append("\n"); 
		query.append("		)					    SLAN_CDS		    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		J.ETD_ADJ_DY			ETD_ADJ_DY			," ).append("\n"); 
		query.append("		J.ETD_ADJ_HRMNT			ETD_ADJ_HRMNT		," ).append("\n"); 
		query.append("		J.DCT_ADJ_TP_NM			DCT_ADJ_TP_NM		," ).append("\n"); 
		query.append("		DECODE(J.DCT_ADJ_TP_NM, 'DAY', '1', '0') IS_DCT_ADJ_DY," ).append("\n"); 
		query.append("		DECODE(J.DCT_ADJ_TP_NM, 'ETB', '1', '0') IS_DCT_ADJ_ETB," ).append("\n"); 
		query.append("		DECODE(J.DCT_ADJ_TP_NM, 'ETD', '1', '0') IS_DCT_ADJ_ETD," ).append("\n"); 
		query.append("		J.DCT_ADJ_DY			DCT_ADJ_DY			," ).append("\n"); 
		query.append("		J.DCT_ADJ_ETB_DYS		DCT_ADJ_ETB_DYS	," ).append("\n"); 
		query.append("		J.DCT_ADJ_ETD_DYS		DCT_ADJ_ETD_DYS		," ).append("\n"); 
		query.append("		J.DCT_ADJ_HRMNT			DCT_ADJ_HRMNT		," ).append("\n"); 
		query.append("		J.CCT_ADJ_TP_NM			CCT_ADJ_TP_NM		," ).append("\n"); 
		query.append("		DECODE(J.CCT_ADJ_TP_NM, 'DAY', '1', '0') IS_CCT_ADJ_DY," ).append("\n"); 
		query.append("		DECODE(J.CCT_ADJ_TP_NM, 'ETB', '1', '0') IS_CCT_ADJ_ETB," ).append("\n"); 
		query.append("		DECODE(J.CCT_ADJ_TP_NM, 'ETD', '1', '0') IS_CCT_ADJ_ETD," ).append("\n"); 
		query.append("		J.CCT_ADJ_DY			CCT_ADJ_DY," ).append("\n"); 
		query.append("		J.CCT_ADJ_ETB_DYS		CCT_ADJ_ETB_DYS," ).append("\n"); 
		query.append("		J.CCT_ADJ_ETD_DYS		CCT_ADJ_ETD_DYS," ).append("\n"); 
		query.append("		J.CCT_ADJ_HRMNT			CCT_ADJ_HRMNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		J.CRE_USR_ID			CRE_USR_ID," ).append("\n"); 
		query.append("		J.CRE_DT				CRE_DT," ).append("\n"); 
		query.append("		J.UPD_USR_ID			UPD_USR_ID," ).append("\n"); 
		query.append("		J.UPD_DT				UPD_DT" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("		SCE_323_ADJ			J" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		J.CUST_TRD_PRNR_ID	=	@[cust_trd_prnr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	AND		J.POL_CD	=	@[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("	AND		J.POD_CD	=	@[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cnt_cd} != '') " ).append("\n"); 
		query.append("AND		J.POL_CNT_CD	=	@[pol_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cnt_cd} != '') " ).append("\n"); 
		query.append("AND		J.POD_CNT_CD	=	@[pod_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		J.DELT_FLG	=	'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     EXISTS" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                          SELECT  'X'      " ).append("\n"); 
		query.append("                                          FROM   SCE_323_ADJ_LANE    LN" ).append("\n"); 
		query.append("                                          WHERE 1 =  1" ).append("\n"); 
		query.append("                                          AND               LN.ADJ_RGST_DT          =         J.ADJ_RGST_DT" ).append("\n"); 
		query.append("                                          AND               LN.ADJ_SEQ                 =         J.ADJ_SEQ" ).append("\n"); 
		query.append("                                          AND               LN.DELT_FLG                =         'N'" ).append("\n"); 
		query.append("                                          AND               LN.SLAN_CD                =         @[slan_cd]" ).append("\n"); 
		query.append("                                          AND               ROWNUM                             =         1   " ).append("\n"); 
		query.append("                                )     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("			POL_CD,	POL_CNT_CD, POD_CD, POD_CNT_CD" ).append("\n"); 

	}
}