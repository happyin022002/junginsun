/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchOldPortExpenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.02.02 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchOldPortExpenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOldPortExpence
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchOldPortExpenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchOldPortExpenceRSQL").append("\n"); 
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
		query.append("SELECT	MAX(SKD_DIR_CD		) AS SKD_DIR_CD" ).append("\n"); 
		query.append(", MAX(PORT_CD			) AS PORT_CD" ).append("\n"); 
		query.append(", MAX(SUBSTR(YD_CD, 6,2)) AS YD_CD" ).append("\n"); 
		query.append(", MAX(CLPT_SEQ			) AS CLPT_SEQ" ).append("\n"); 
		query.append(", PORT_ROTN_SEQ" ).append("\n"); 
		query.append(", MAX(SEQ) 				  AS CLASS_CNT" ).append("\n"); 
		query.append(", MAX(VSL_CLASS01		) AS VSL_CLASS01" ).append("\n"); 
		query.append(", MAX(N1ST_VSL_CLSS_KNT	) AS CLASS_CNT01" ).append("\n"); 
		query.append(", MAX(VSL_CLASS02		) AS VSL_CLASS02" ).append("\n"); 
		query.append(", MAX(N2ND_VSL_CLSS_KNT	) AS CLASS_CNT02" ).append("\n"); 
		query.append(", MAX(VSL_CLASS03		) AS VSL_CLASS03" ).append("\n"); 
		query.append(", MAX(N3RD_VSL_CLSS_KNT	) AS CLASS_CNT03" ).append("\n"); 
		query.append(", MAX(SUM_CLASS01		) AS SUM_CLASS01" ).append("\n"); 
		query.append(", MAX(SUM_CLASS02		) AS SUM_CLASS02" ).append("\n"); 
		query.append(", MAX(SUM_CLASS03		) AS SUM_CLASS03" ).append("\n"); 
		query.append(", SUM(NVL(SUM_CLASS01, 0) + NVL(SUM_CLASS02, 0) + NVL(SUM_CLASS03, 0)) / MAX(SEQ) AS CLASS_AVG" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  SEQ, VSL_CLSS_CD, SKD_DIR_CD, PORT_CD, CLPT_SEQ, PORT_ROTN_SEQ, YD_CD" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 1, VSL_CLSS_CD	)) AS VSL_CLASS01" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 1, VSL_CLSS_KNT	)) AS N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 1, PE_AMT			)) AS SUM_CLASS01" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 2, VSL_CLSS_CD	)) AS VSL_CLASS02" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 2, VSL_CLSS_KNT	)) AS N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 2, PE_AMT			)) AS SUM_CLASS02" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 3, VSL_CLSS_CD	)) AS VSL_CLASS03" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 3, VSL_CLSS_KNT	)) AS N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append(", MAX(DECODE(SEQ, 3, PE_AMT			)) AS SUM_CLASS03" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX (T XPKVSK_SLT_PRC_PORT_DTL) +*/" ).append("\n"); 
		query.append("T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, T2.PORT_CD, T2.SKD_DIR_CD" ).append("\n"); 
		query.append(", T2.YD_CD, T2.CLPT_SEQ" ).append("\n"); 
		query.append(", T2.PORT_ROTN_SEQ, T1.VSL_CLSS_CD, T2.PE_AMT, T1.VSL_CLSS_KNT" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (ORDER BY T2.VSL_CLSS_CD) AS SEQ" ).append("\n"); 
		query.append("FROM    VSK_SLT_PRC_DTL T1, VSK_SLT_PRC_PORT_DTL T2" ).append("\n"); 
		query.append("WHERE   1                   = 1" ).append("\n"); 
		query.append("AND		T1.VSL_SLAN_CD		= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND		T1.PF_SVC_TP_CD		= T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND		T1.SLT_PRC_WRK_YR	= T2.SLT_PRC_WRK_YR" ).append("\n"); 
		query.append("AND		T1.BSE_QTR_CD		= T2.BSE_QTR_CD" ).append("\n"); 
		query.append("AND		T1.VSL_CLSS_CD		= T2.VSL_CLSS_CD" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     T1.PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND     T1.SLT_PRC_WRK_YR  = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND     T1.BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VSL_CLSS_CD, PORT_ROTN_SEQ, PORT_CD,YD_CD, SEQ,SKD_DIR_CD, CLPT_SEQ, PORT_ROTN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PORT_ROTN_SEQ" ).append("\n"); 
		query.append("ORDER BY PORT_ROTN_SEQ" ).append("\n"); 

	}
}