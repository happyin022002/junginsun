/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchEDIGrpIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.04 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchEDIGrpIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchEDIGrpIDRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchEDIGrpIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchEDIGrpIDRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED*/" ).append("\n"); 
		query.append("DISTINCT  A.ESVC_GRP_CD    AS GRP_ID" ).append("\n"); 
		query.append("--, A.CNT_CD         AS CNT_CD" ).append("\n"); 
		query.append("--, A.CUST_SEQ       AS CUST_SEQ" ).append("\n"); 
		query.append(", CUST_TRD_PRNR_ID AS EDI_ID" ).append("\n"); 
		query.append(", ESVC_GRP_NM      AS GRP_NM" ).append("\n"); 
		query.append(", BKG_CFM_FLG      AS CFM_FLG" ).append("\n"); 
		query.append(", BL_DRFT_FLG      AS DRF_FLG" ).append("\n"); 
		query.append(", CGO_TRAK_FLG     AS CGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_EDI_GRP_CUST A, BKG_EDI_GRP B" ).append("\n"); 
		query.append("WHERE A.ESVC_GRP_CD = B.ESVC_GRP_CD" ).append("\n"); 
		query.append("AND   A.CO_CD       = B.CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '' || ${cust_seq} != '')" ).append("\n"); 
		query.append("AND   A.ESVC_GRP_CD > ' '" ).append("\n"); 
		query.append("AND   A.CO_CD       > ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_cd} != '' )" ).append("\n"); 
		query.append("AND   A.CNT_CD      = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("#if (${cnt_cd} == '' )" ).append("\n"); 
		query.append("AND   A.CNT_CD  > ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.CUST_SEQ    LIKE @[cust_seq]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${grp_id} != '')" ).append("\n"); 
		query.append("AND   A.ESVC_GRP_CD        LIKE '%'||@[grp_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_id} != '')" ).append("\n"); 
		query.append("AND   B.CUST_TRD_PRNR_ID   LIKE '%'||@[edi_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${grp_nm} != '')" ).append("\n"); 
		query.append("AND   B.ESVC_GRP_NM        LIKE '%'||@[grp_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}