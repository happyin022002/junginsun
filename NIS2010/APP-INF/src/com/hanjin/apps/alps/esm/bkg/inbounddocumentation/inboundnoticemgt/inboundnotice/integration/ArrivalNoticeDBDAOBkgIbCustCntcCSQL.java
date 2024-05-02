/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ArrivalNoticeDBDAOBkgIbCustCntcCSQL.java
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

public class ArrivalNoticeDBDAOBkgIbCustCntcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOBkgIbCustCntcCSQL(){
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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOBkgIbCustCntcCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_ib_cust_cntc" ).append("\n"); 
		query.append("  (ofc_cd" ).append("\n"); 
		query.append("  ,cust_cnt_cd" ).append("\n"); 
		query.append("  ,cust_seq" ).append("\n"); 
		query.append("  ,cust_cntc_tp_cd" ).append("\n"); 
		query.append("  ,cntc_desc" ).append("\n"); 
		query.append("  ,fax_no" ).append("\n"); 
		query.append("  ,fax_snd_flg" ).append("\n"); 
		query.append("  ,phn_no" ).append("\n"); 
		query.append("  ,mphn_no" ).append("\n"); 
		query.append("  ,cntc_eml" ).append("\n"); 
		query.append("  ,eml_snd_flg" ).append("\n"); 
		query.append("  ,cntc_rmk" ).append("\n"); 
		query.append("  ,val_fax_no" ).append("\n"); 
		query.append("  --,delt_flg" ).append("\n"); 
		query.append("  ,upd_locl_dt" ).append("\n"); 
		query.append("  ,upd_locl_gdt " ).append("\n"); 
		query.append("  ,cre_usr_id" ).append("\n"); 
		query.append("  ,cre_dt" ).append("\n"); 
		query.append("  ,upd_usr_id" ).append("\n"); 
		query.append("  ,upd_dt)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("  (@[ofc_cd]" ).append("\n"); 
		query.append("  ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("  ,@[cust_seq]" ).append("\n"); 
		query.append("  ,@[cust_cntc_tp_cd]" ).append("\n"); 
		query.append("  ,@[cntc_desc]" ).append("\n"); 
		query.append("  ,@[fax_no]" ).append("\n"); 
		query.append("  ,decode(@[fax_snd_flg],1,'N',0,'Y')" ).append("\n"); 
		query.append("  ,@[phn_no]" ).append("\n"); 
		query.append("  ,@[mphn_no]" ).append("\n"); 
		query.append("  ,@[cntc_eml]" ).append("\n"); 
		query.append("  ,decode(@[eml_snd_flg],1,'N',0,'Y')" ).append("\n"); 
		query.append("  ,@[cntc_rmk]" ).append("\n"); 
		query.append("  ,@[val_fax_no]" ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[evnt_ofc_cd]) " ).append("\n"); 
		query.append("  ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT' )" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,sysdate" ).append("\n"); 
		query.append("  ,@[upd_usr_id]" ).append("\n"); 
		query.append("  ,sysdate)" ).append("\n"); 

	}
}