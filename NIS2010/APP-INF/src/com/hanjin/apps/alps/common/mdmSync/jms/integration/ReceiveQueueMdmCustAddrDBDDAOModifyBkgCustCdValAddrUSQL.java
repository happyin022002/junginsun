/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReceiveQueueMdmCustAddrDBDDAOModifyBkgCustCdValAddrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2011.03.25 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim simon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCustAddrDBDDAOModifyBkgCustCdValAddrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify BkgCust Address
	  * </pre>
	  */
	public ReceiveQueueMdmCustAddrDBDDAOModifyBkgCustCdValAddrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCustAddrDBDDAOModifyBkgCustCdValAddrUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUST_CD_VAL                                                          " ).append("\n"); 
		query.append("SET  VAL_CUST_ADDR = NVL((" ).append("\n"); 
		query.append("							SELECT /*+ INDEX_DESC(ADDR XPKMDM_CUST_ADDR) */" ).append("\n"); 
		query.append("                                       ADDR.BZET_ADDR" ).append("\n"); 
		query.append("                                  FROM MDM_CUST_ADDR ADDR " ).append("\n"); 
		query.append("                                 WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                                   AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                   AND ADDR.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("                                   AND ADDR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                                   AND ADDR.ADDR_TP_CD ='1'" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1 " ).append("\n"); 
		query.append("					), VAL_CUST_ADDR )," ).append("\n"); 
		query.append("     UPD_USR_ID  = NVL(@[upd_usr_id], 'MDMCUST')," ).append("\n"); 
		query.append(" 	 UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   CUST_SEQ    = @[cust_seq]" ).append("\n"); 

	}
}