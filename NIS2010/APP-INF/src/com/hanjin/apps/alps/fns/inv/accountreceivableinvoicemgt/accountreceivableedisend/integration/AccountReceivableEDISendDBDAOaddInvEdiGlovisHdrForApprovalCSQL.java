/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrForApprovalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.16 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrForApprovalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 청구 상태에서 glovis edi 데이터 재전송하기 위해서 header table에 data insert
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrForApprovalCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrForApprovalCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  AR_IF_NO" ).append("\n"); 
		query.append(", IF_SEQ" ).append("\n"); 
		query.append(", BL_SRC_NO" ).append("\n"); 
		query.append(", GLOVIS_EDI_MSG_NO" ).append("\n"); 
		query.append(", INV_NO " ).append("\n"); 
		query.append(", INV_SEQ" ).append("\n"); 
		query.append(", CUST_NM" ).append("\n"); 
		query.append(", CUST_EML" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", SAIL_ARR_DT" ).append("\n"); 
		query.append(", INV_RMK" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", EDI_SND_FLG" ).append("\n"); 
		query.append(", EDI_SND_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(", NVL((SELECT MAX(IF_SEQ)" ).append("\n"); 
		query.append("     	 FROM INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("        WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("          ),0)+1" ).append("\n"); 
		query.append(", @[bl_src_no]" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TO_CHAR(INV_EDI_GLOVIS_MSG_SEQ.NEXTVAL),4,'0')" ).append("\n"); 
		query.append(", @[bl_src_no] -- 2010.12.16 임창빈 수석 요청" ).append("\n"); 
		query.append(", NVL((SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("     	         FROM INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("                WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("          ),0)+1" ).append("\n"); 
		query.append(", @[cust_nm]" ).append("\n"); 
		query.append(", @[cust_eml]" ).append("\n"); 
		query.append(", @[cust_cnt_cd]" ).append("\n"); 
		query.append(", @[cust_seq]" ).append("\n"); 
		query.append(", @[io_bnd_cd]" ).append("\n"); 
		query.append(", @[sail_arr_dt]" ).append("\n"); 
		query.append(", @[inv_rmk]" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}