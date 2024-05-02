/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchStatusSoldDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.10 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchStatusSoldDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Re-Sold Creation를 하기 위해 과거 Sold 정보가 MNR 모듈에 있는지 확인해서 해당 정보를 조회한다.
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchStatusSoldDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchStatusSoldDataRSQL").append("\n"); 
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
		query.append("SELECT  EQ_NO" ).append("\n"); 
		query.append("      , FLAG_OFC_CD" ).append("\n"); 
		query.append("      , FLAG_YD_CD" ).append("\n"); 
		query.append("      , FLAG_DT" ).append("\n"); 
		query.append("      , CUST_CNT_CD" ).append("\n"); 
		query.append("      , CUST_SEQ" ).append("\n"); 
		query.append("      , FLAG_USER_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T2.EQ_NO                AS EQ_NO" ).append("\n"); 
		query.append("                , T1.RQST_OFC_CD        AS FLAG_OFC_CD" ).append("\n"); 
		query.append("                , T2.DISP_YD_CD         AS FLAG_YD_CD" ).append("\n"); 
		query.append("                , TO_CHAR(DECODE(SIGN(T3.CNMV_DT - T2.DISP_SOLD_DT), -1, T2.DISP_SOLD_DT, T3.CNMV_DT), 'YYYYMMDD')  AS FLAG_DT        " ).append("\n"); 
		query.append("                , T2.MNR_PRNR_CNT_CD    AS CUST_CNT_CD" ).append("\n"); 
		query.append("                , T2.MNR_PRNR_SEQ       AS CUST_SEQ" ).append("\n"); 
		query.append("                , T2.CRE_USR_ID         AS FLAG_USER_ID" ).append("\n"); 
		query.append("                , TO_CHAR(T2.CRE_DT, 'YYYYMMDD')                                                   AS CRE_DT" ).append("\n"); 
		query.append("                , ROW_NUMBER () OVER (PARTITION BY T2.EQ_NO ORDER BY T2.DISP_SOLD_DT DESC, T2.CRE_DT DESC) AS NO" ).append("\n"); 
		query.append("        FROM    MNR_DISP_HDR    T1," ).append("\n"); 
		query.append("                MNR_DISP_DTL    T2," ).append("\n"); 
		query.append("                MST_CONTAINER   T3" ).append("\n"); 
		query.append("        WHERE   T1.DISP_NO  = T2.DISP_NO" ).append("\n"); 
		query.append("        AND     T2.EQ_NO    = T3.CNTR_NO" ).append("\n"); 
		query.append("        AND     T1.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("        AND     T2.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND     T2.EQ_NO    = @[eq_no]" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("WHERE   NO = 1" ).append("\n"); 

	}
}