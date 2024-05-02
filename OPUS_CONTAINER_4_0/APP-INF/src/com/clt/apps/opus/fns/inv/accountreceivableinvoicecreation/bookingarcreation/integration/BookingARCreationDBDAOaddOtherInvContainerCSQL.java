/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOaddOtherInvContainerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.11.27 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOaddOtherInvContainerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOaddOtherInvContainerCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOaddOtherInvContainerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOaddOtherInvContainerCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_CNTR(" ).append("\n"); 
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",CNTR_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[cntr_seq]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",TO_DATE(@[cre_dt] ,'YYYY-MM-DD HH24:MI:SS.%')" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",TO_DATE(@[upd_dt] ,'YYYY-MM-DD HH24:MI:SS.%')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}