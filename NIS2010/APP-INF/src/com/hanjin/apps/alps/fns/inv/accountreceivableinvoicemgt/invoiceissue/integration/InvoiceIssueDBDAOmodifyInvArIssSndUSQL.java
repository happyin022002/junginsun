/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOmodifyInvArIssSndUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOmodifyInvArIssSndUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 지역에서 입력된 Email에 대한 전송 결과에 대해 해당 정보를 변경한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOmodifyInvArIssSndUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack_svr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_eml_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOmodifyInvArIssSndUSQL").append("\n"); 
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
		query.append("UPDATE  INV_AR_ISS_SND" ).append("\n"); 
		query.append("SET     EUR_EML_SND_RSLT_CD 		= @[eur_eml_snd_rslt_cd] 				--SND_RESULT" ).append("\n"); 
		query.append(", ACK_SVR_CD               	= @[ack_svr_cd]							--ACK_SERVER" ).append("\n"); 
		query.append(", ERR_DESC           		= SUBSTR(@[err_desc], 1, 500)			--ERR_DESC" ).append("\n"); 
		query.append(", SND_DT					= TO_DATE(@[snd_dt], 'YYYYMMDDHH24MISS')-- ACK_DT" ).append("\n"); 
		query.append(", UPD_USR_ID        		= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT            		= SYSDATE" ).append("\n"); 
		query.append("WHERE   INV_SND_NO          	    = @[inv_snd_no]		-- EML_SND_NO" ).append("\n"); 
		query.append("AND      INV_ISS_SND_TP_CD    		= 'E' 				-- EMAIL" ).append("\n"); 

	}
}