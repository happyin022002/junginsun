/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOnDockTrdPartyVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.08.31 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchOnDockTrdPartyVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOnDockTrdPartyVolume
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOnDockTrdPartyVolumeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOnDockTrdPartyVolumeRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("T.tml_if_ofc_cd       ," ).append("\n"); 
		query.append("T.tml_if_seq          ," ).append("\n"); 
		query.append("T.tml_n3pty_tp_cd     ," ).append("\n"); 
		query.append("T.tml_n3pty_if_sts_cd ," ).append("\n"); 
		query.append("T.calc_cost_grp_cd    ," ).append("\n"); 
		query.append("T.tml_inv_tp_cd       ," ).append("\n"); 
		query.append("T.inv_no              ," ).append("\n"); 
		query.append("T.err_inv_no          ," ).append("\n"); 
		query.append("LPAD(T.vndr_seq, 6, '0') vndr_seq," ).append("\n"); 
		query.append("T.yd_cd               ," ).append("\n"); 
		query.append("T.lgs_cost_cd         ," ).append("\n"); 
		query.append("T.acct_cd             ," ).append("\n"); 
		query.append("T.tml_so_ofc_cty_cd   ," ).append("\n"); 
		query.append("T.tml_so_seq          ," ).append("\n"); 
		query.append("T.tml_so_dtl_seq      ," ).append("\n"); 
		query.append("T.csr_no              ," ).append("\n"); 
		query.append("P.n3pty_bil_tp_nm     ," ).append("\n"); 
		query.append("T.cntr_no             ," ).append("\n"); 
		query.append("T.cntr_tpsz_cd        ," ).append("\n"); 
		query.append("T.bkg_no              ," ).append("\n"); 
		query.append("--T.bkg_no_split        ," ).append("\n"); 
		query.append("T.bl_no               ," ).append("\n"); 
		query.append("--T.bl_no_tp            ," ).append("\n"); 
		query.append("--T.bl_no_chk           ," ).append("\n"); 
		query.append("T.finc_vsl_cd         ," ).append("\n"); 
		query.append("T.finc_skd_voy_no     ," ).append("\n"); 
		query.append("T.finc_skd_dir_cd     ," ).append("\n"); 
		query.append("T.io_bnd_cd           ," ).append("\n"); 
		query.append("T.ref_vndr_seq        ," ).append("\n"); 
		query.append("T.tml_crr_cd          ," ).append("\n"); 
		query.append("T.vndr_cust_div_cd    ," ).append("\n"); 
		query.append("T.vndr_cnt_cd         ," ).append("\n"); 
		query.append("T.n3pty_vndr_seq      ," ).append("\n"); 
		query.append("T.cust_cnt_cd         ," ).append("\n"); 
		query.append("T.cust_seq            ," ).append("\n"); 
		query.append("T.n3pty_ofc_cd        ," ).append("\n"); 
		query.append("T.curr_cd             ," ).append("\n"); 
		query.append("T.if_amt              ," ).append("\n"); 
		query.append("T.if_rmk" ).append("\n"); 
		query.append("from TES_N3RD_PTY_IF T, TPB_N3RD_PTY_BIL_TP P" ).append("\n"); 
		query.append("where T.tml_so_ofc_cty_cd = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("and   T.tml_so_seq = @[tml_so_seq]" ).append("\n"); 
		query.append("and   T.tml_so_dtl_seq = @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("and   T.n3pty_bil_tp_cd = P.n3pty_bil_tp_cd" ).append("\n"); 

	}
}