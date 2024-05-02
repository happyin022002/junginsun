/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GuaranteeManageDBDAOModifyUSGuaranteeHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOModifyUSGuaranteeHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Header Info Update
	  * </pre>
	  */
	public GuaranteeManageDBDAOModifyUSGuaranteeHdrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dept_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOModifyUSGuaranteeHdrUSQL").append("\n"); 
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
		query.append("UPDATE	TES_GNTE_HDR SET" ).append("\n"); 
		query.append("		  GNTE_TP_CD	= @[gnte_tp_cd]" ).append("\n"); 
		query.append("		, CURR_CD		= @[curr_cd]   " ).append("\n"); 
		query.append("		, VNDR_SEQ      = @[vndr_seq]     " ).append("\n"); 
		query.append("		, GNTE_CUST_CD	= @[gnte_cust_cd]  " ).append("\n"); 
		query.append("		, BKG_STS_CD    = @[bkg_sts_cd]" ).append("\n"); 
		query.append("        , YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("		, TTL_AMT       = @[ttl_amt]   " ).append("\n"); 
		query.append("		, PIC_PHN_NO    = @[pic_phn_no]" ).append("\n"); 
		query.append("		, PIC_FAX_NO    = @[pic_fax_no]" ).append("\n"); 
		query.append("		, DEPT_NO       = @[dept_no]   " ).append("\n"); 
		query.append("		, GNTE_RMK      = @[gnte_rmk]" ).append("\n"); 
		query.append("		, UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append("		, UPD_DT		= SYSDATE" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		NVL(DMY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND		GNTE_NO = @[gnte_no]" ).append("\n"); 

	}
}