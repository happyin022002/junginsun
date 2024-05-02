/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOmodifyIssueFlagMainUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.08 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOmodifyIssueFlagMainUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyIssueFlagMain
	  * </pre>
	  */
	public BookingARCreationDBDAOmodifyIssueFlagMainUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOmodifyIssueFlagMainUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN A" ).append("\n"); 
		query.append("    SET INV_ISS_FLG = @[iss_flg]" ).append("\n"); 
		query.append("       ,ISS_DT = DECODE(SUBSTR(@[inv_no],1,1),'F',NVL(ISS_DT,(SELECT NVL(MIN(ISS_DT), TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(AR_OFC_CD), 'YYYYMMDD')) FROM INV_AR_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = 1)), (SELECT NVL(MIN(ISS_DT), TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(AR_OFC_CD), 'YYYYMMDD')) FROM INV_AR_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = 1)) " ).append("\n"); 
		query.append("       ,INV_NO = DECODE(SUBSTR(@[inv_no],1,1),'F',NVL(INV_NO,@[inv_no]), @[inv_no])" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("       ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("  WHERE AR_IF_NO IN (SELECT AR_IF_NO" ).append("\n"); 
		query.append("                       FROM INV_AR_ISS_DTL" ).append("\n"); 
		query.append("                      WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                        AND AR_IF_NO = A.AR_IF_NO)" ).append("\n"); 

	}
}