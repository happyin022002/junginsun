/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgoforNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchAwkCgoforNewBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT AC.BKG_NO," ).append("\n"); 
		query.append("       @[bkg_skd_seq] AS BKG_SKD_SEQ," ).append("\n"); 
		query.append("       AC.AWK_CGO_SEQ," ).append("\n"); 
		query.append("       AC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       AC.CNTR_VOL_QTY," ).append("\n"); 
		query.append("       AC.CNTR_NO," ).append("\n"); 
		query.append("       AC.OVR_HGT," ).append("\n"); 
		query.append("       AC.OVR_LF_LEN," ).append("\n"); 
		query.append("       AC.OVR_RT_LEN," ).append("\n"); 
		query.append("       AC.OVR_FWRD_LEN," ).append("\n"); 
		query.append("       AC.OVR_BKWD_LEN," ).append("\n"); 
		query.append("       AC.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO AC," ).append("\n"); 
		query.append("       BKG_VVD BV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE AC.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%' " ).append("\n"); 
		query.append("   AND BV.VSL_Cd = @[vsl_cd]" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND AC.BKG_NO = BV.BKG_NO" ).append("\n"); 

	}
}