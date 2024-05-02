/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOSearchQueueDetail1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.07 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchQueueDetail1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchQueueDetail1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchQueueDetail1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchQueueDetail1RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SR_KND_CD,BKG_NO,SR_NO," ).append("\n"); 
		query.append("RSN_BKG_MN_FLG    AS BKG_MAIN,           /*  BKG  MAIN */" ).append("\n"); 
		query.append("RSN_CUST_INFO_FLG AS CUSTOMER_INFO,      /* CUSTOMER  INFO */" ).append("\n"); 
		query.append("RSN_CNTR_FLG      AS FRT_CHARGE,         /* FRT & CHARGE */" ).append("\n"); 
		query.append("RSN_FRT_CHG_FLG   AS CONTAINER,          /*  CONTAINER */" ).append("\n"); 
		query.append("RSN_CNTR_MF_FLG   AS CONTAINER_MANIFEST, /* CONTAINER MANIFEST */" ).append("\n"); 
		query.append("RSN_DCGO_FLG      AS DANGER,             /* DANGER */" ).append("\n"); 
		query.append("RSN_AWK_CGO_FLG   AS AWKWARD,            /* AWKWARD */" ).append("\n"); 
		query.append("RSN_RC_FLG        AS REEFER,             /* REEFER */" ).append("\n"); 
		query.append("RSN_BB_CGO_FLG    AS B_BULK,             /* B/BULK */" ).append("\n"); 
		query.append("RSN_RLY_PORT_FLG  AS RLY_VVD_PORT,       /* RLY VVD & PORT */" ).append("\n"); 
		query.append("RSN_NEW_BKG_FLG   AS NEW_BKG,            /* NEW  BKG */" ).append("\n"); 
		query.append("RSN_SPLIT_FLG     AS BKG_SPLIT,          /* BKG  SPLIT */" ).append("\n"); 
		query.append("RSN_BL_INFO_FLG   AS BL_INFORM,          /* B/L  INFORM */" ).append("\n"); 
		query.append("RSN_HBL_FLG       AS NVO_HOUSE_BL,       /* NVO HOUSE B/L */" ).append("\n"); 
		query.append("'우선 패스'       AS CUSTOMER_VERIFICATION /* CUSTOMER VERIFICATION */" ).append("\n"); 
		query.append("FROM BKG_SR_HIS X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_NO  = @[sr_no]" ).append("\n"); 
		query.append("AND SR_HIS_SEQ =(SELECT NVL(MAX(SR_HIS_SEQ),0)" ).append("\n"); 
		query.append("FROM   BKG_SR_HIS" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}