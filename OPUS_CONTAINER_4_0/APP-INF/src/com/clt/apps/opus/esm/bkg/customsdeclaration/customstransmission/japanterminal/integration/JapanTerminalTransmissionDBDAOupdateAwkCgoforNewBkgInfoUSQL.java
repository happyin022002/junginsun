/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOupdateAwkCgoforNewBkgInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.21 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOupdateAwkCgoforNewBkgInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * updateAwkCgoforNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOupdateAwkCgoforNewBkgInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_rt_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_bkwd_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_lf_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_fwrd_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOupdateAwkCgoforNewBkgInfoUSQL").append("\n");
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
		query.append("UPDATE BKG_TML_EDI_JP_AWK_CGO SET" ).append("\n");
		query.append("CNTR_TPSZ_CD     = @[cntr_tpsz_cd]" ).append("\n");
		query.append(", CNTR_VOL_QTY     = @[cntr_vol_qty]" ).append("\n");
		query.append(", CNTR_NO          = @[cntr_no]" ).append("\n");
		query.append(", OVR_HGT          = @[ovr_hgt]" ).append("\n");
		query.append(", OVR_LF_LEN       = @[ovr_lf_len]" ).append("\n");
		query.append(", OVR_RT_LEN       = @[ovr_rt_len]" ).append("\n");
		query.append(", OVR_FWRD_LEN     = @[ovr_fwrd_len]" ).append("\n");
		query.append(", OVR_BKWD_LEN     = @[ovr_bkwd_len]" ).append("\n");
		query.append(", OVR_VOID_SLT_QTY = @[ovr_void_slt_qty]" ).append("\n");
		query.append(", CRE_USR_ID       = @[cre_usr_id]" ).append("\n");
		query.append(", CRE_DT           = SYSDATE" ).append("\n");
		query.append(", UPD_USR_ID       = @[cre_usr_id]" ).append("\n");
		query.append(", UPD_DT           = SYSDATE" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n");
		query.append("AND AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n");

	}
}