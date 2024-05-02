/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ArrivalNoticeDBDAOBkgIbCustCntcHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOBkgIbCustCntcHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOBkgIbCustCntcHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cntc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cntc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOBkgIbCustCntcHisCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_ib_cust_cntc_his" ).append("\n"); 
		query.append("    (cust_cnt_cd" ).append("\n"); 
		query.append("    ,cust_seq" ).append("\n"); 
		query.append("    ,ofc_cd" ).append("\n"); 
		query.append("    ,cust_cntc_tp_cd" ).append("\n"); 
		query.append("    ,his_seq" ).append("\n"); 
		query.append("    ,cntc_via_cd" ).append("\n"); 
		query.append("    ,old_cntc_ctnt" ).append("\n"); 
		query.append("    ,new_cntc_ctnt" ).append("\n"); 
		query.append("    ,bl_no  " ).append("\n"); 
		query.append("    ,auto_mnl_flg" ).append("\n"); 
		query.append("    ,snd_sel_flg" ).append("\n"); 
		query.append("    ,cng_dt" ).append("\n"); 
		query.append("    ,cng_usr_id" ).append("\n"); 
		query.append("    ,cre_usr_id" ).append("\n"); 
		query.append("    ,cre_dt" ).append("\n"); 
		query.append("    ,upd_usr_id" ).append("\n"); 
		query.append("    ,upd_dt)" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("    (@[cust_cnt_cd]" ).append("\n"); 
		query.append("    ,@[cust_seq]" ).append("\n"); 
		query.append("    ,@[ofc_cd]" ).append("\n"); 
		query.append("    ,@[cust_cntc_tp_cd]" ).append("\n"); 
		query.append("    ,(select nvl(max(his_seq),0) + 1 from bkg_ib_cust_cntc_his" ).append("\n"); 
		query.append("             where     cust_cnt_cd     = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                   and cust_seq        = @[cust_seq]" ).append("\n"); 
		query.append("                   and ofc_cd          = @[ofc_cd]" ).append("\n"); 
		query.append("                   and cust_cntc_tp_cd = @[cust_cntc_tp_cd])" ).append("\n"); 
		query.append("    ,@[cntc_via_cd]" ).append("\n"); 
		query.append("    ,@[old_cntc_ctnt]" ).append("\n"); 
		query.append("    ,@[new_cntc_ctnt]" ).append("\n"); 
		query.append("    ,@[bl_no]    " ).append("\n"); 
		query.append("    ,@[auto_mnl_flg]" ).append("\n"); 
		query.append("    ,decode(@[snd_sel_flg],1,'N',0,'Y')" ).append("\n"); 
		query.append("    ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[evnt_ofc_cd]) " ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}