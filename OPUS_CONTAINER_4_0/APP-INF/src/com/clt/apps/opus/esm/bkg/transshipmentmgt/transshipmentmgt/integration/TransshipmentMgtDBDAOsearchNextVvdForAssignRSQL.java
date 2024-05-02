/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchNextVvdForAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.06.22 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchNextVvdForAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건에 맞는 출항 vvd들을 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchNextVvdForAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("former_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("relay_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("former_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchNextVvdForAssignRSQL").append("\n"); 
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
		query.append("select next_skd_to.vsl_cd||next_skd_to.skd_voy_no||next_skd_to.skd_dir_cd next_vvd" ).append("\n"); 
		query.append("		, next_skd_to.slan_cd" ).append("\n"); 
		query.append("        , oop.op_cd " ).append("\n"); 
		query.append("        , to_char(next_skd_from.vps_etd_dt, 'yyyy-mm-dd hh24') etd " ).append("\n"); 
		query.append("        , to_char(next_skd_to.vps_eta_dt,   'yyyy-mm-dd hh24') eta " ).append("\n"); 
		query.append("        , rly_skd.vps_port_cd    ||substr(next_skd_from.yd_cd, 6, 2) relay_tmnl " ).append("\n"); 
		query.append("        , next_skd_to.vps_port_cd||substr(next_skd_to.yd_cd, 6, 2) next_tmnl" ).append("\n"); 
		query.append("        , next_skd_to.CLPT_IND_SEQ next_seq" ).append("\n"); 
		query.append("from      vsk_vsl_port_skd rly_skd " ).append("\n"); 
		query.append("        , vsk_vsl_port_skd next_skd_from " ).append("\n"); 
		query.append("        , vsk_vsl_port_skd next_skd_to " ).append("\n"); 
		query.append("        , bkg_vsl_oop oop" ).append("\n"); 
		query.append("where next_skd_from.vsl_cd = oop.vsl_cd(+)" ).append("\n"); 
		query.append("  and rly_skd.vps_eta_dt   < next_skd_from.vps_etd_dt" ).append("\n"); 
		query.append("  and rly_skd.vsl_cd       = substr(@[former_vvd], 1, 4)  " ).append("\n"); 
		query.append("  and rly_skd.skd_voy_no   = substr(@[former_vvd], 5, 4) " ).append("\n"); 
		query.append("  and rly_skd.skd_dir_cd   = substr(@[former_vvd], 9, 1)  " ).append("\n"); 
		query.append("  and rly_skd.vps_port_cd  = @[relay_port] " ).append("\n"); 
		query.append("  and rly_skd.CLPT_IND_SEQ = @[former_clpt_ind_seq]" ).append("\n"); 
		query.append("  and rly_skd.vps_port_cd  = next_skd_from.vps_port_cd" ).append("\n"); 
		query.append("	--and rly_skd.CLPT_IND_SEQ = next_skd_from.CLPT_IND_SEQ " ).append("\n"); 
		query.append("  and next_skd_to.vps_port_cd = @[next_port] " ).append("\n"); 
		query.append("  and next_skd_from.vsl_cd      = next_skd_to.vsl_cd" ).append("\n"); 
		query.append("  and next_skd_from.skd_voy_no  = next_skd_to.skd_voy_no" ).append("\n"); 
		query.append("  and next_skd_from.skd_dir_cd  = next_skd_to.skd_dir_cd" ).append("\n"); 
		query.append("  and next_skd_from.CLPT_SEQ < next_skd_to.CLPT_SEQ" ).append("\n"); 
		query.append("  and nvl(next_skd_from.skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("  and nvl(next_skd_to.skd_cng_sts_cd,   ' ') <> 'S'" ).append("\n"); 
		query.append("  and next_skd_from.vps_etd_dt > nvl(greatest(to_date(@[etb_to], 'yyyymmdd'), sysdate), sysdate)" ).append("\n"); 
		query.append("  and next_skd_from.vps_etd_dt < nvl(greatest(to_date(@[etb_to], 'yyyymmdd'), sysdate), sysdate)+ 16" ).append("\n"); 
		query.append("  order by etd,next_vvd,relay_tmnl" ).append("\n"); 

	}
}