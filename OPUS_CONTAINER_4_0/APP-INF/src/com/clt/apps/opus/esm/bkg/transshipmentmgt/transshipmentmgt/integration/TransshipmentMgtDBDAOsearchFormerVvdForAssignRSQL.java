/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchFormerVvdForAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.06.21 Maeda Atsushi
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

public class TransshipmentMgtDBDAOsearchFormerVvdForAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건에 맞는 입항 vvd들을 조회한다.   
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchFormerVvdForAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TransshipmentMgtDBDAOsearchFormerVvdForAssignRSQL").append("\n"); 
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
		query.append("select distinct former_skd.vsl_cd||former_skd.skd_voy_no||former_skd.skd_dir_cd former_vvd" ).append("\n"); 
		query.append("        , to_char(former_skd.vps_etb_dt, 'yyyymmdd') etb" ).append("\n"); 
		query.append("        , former_skd.yd_cd pod_yd_cd" ).append("\n"); 
		query.append("        , former_skd.CLPT_IND_SEQ FORMER_CLPT_IND_SEQ " ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_vvd former_vvd" ).append("\n"); 
		query.append("        , bkg_vvd next_vvd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd former_skd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd next_skd" ).append("\n"); 
		query.append(" where bk.bkg_no               = former_vvd.bkg_no " ).append("\n"); 
		query.append("   and bk.bkg_no               = next_vvd.bkg_no " ).append("\n"); 
		query.append("   and former_vvd.pod_cd       = next_vvd.pol_cd" ).append("\n"); 
		query.append("   and bk.bkg_sts_cd           not in ('X', 'S')" ).append("\n"); 
		query.append("   and former_vvd.vsl_cd            = former_skd.vsl_cd" ).append("\n"); 
		query.append("   and former_vvd.skd_voy_no        = former_skd.skd_voy_no" ).append("\n"); 
		query.append("   and former_vvd.skd_dir_cd        = former_skd.skd_dir_cd" ).append("\n"); 
		query.append("   and former_vvd.pod_cd            = former_skd.vps_port_cd" ).append("\n"); 
		query.append("   and former_vvd.pod_CLPT_IND_SEQ  = former_skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   and NVL(next_vvd.vsl_cd, '')              = next_skd.vsl_cd(+)" ).append("\n"); 
		query.append("   and NVL(next_vvd.skd_voy_no, '')          = next_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and NVL(next_vvd.skd_dir_cd, '')          = next_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and NVL(next_vvd.pol_cd, '')              = next_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.pol_CLPT_IND_SEQ    = next_skd.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${relay_port} !='')" ).append("\n"); 
		query.append("   	and former_vvd.pod_cd        = substr(@[relay_port], 1, 5)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${relay_port} !='')" ).append("\n"); 
		query.append("   	and former_vvd.pod_yd_cd     like @[relay_port]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${former_vvd}!='')" ).append("\n"); 
		query.append("   	and former_vvd.vsl_cd        = substr(@[former_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_voy_no    = substr(@[former_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_dir_cd    = substr(@[former_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${former_vvd} =='' && ${etb_from}!='' && ${etb_to}!='')" ).append("\n"); 
		query.append(" 	and former_skd.vps_etb_dt    >= to_date(@[etb_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("   	and former_skd.vps_etb_dt    <= to_date(@[etb_to],   'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("   #end  " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${pol_cd} !='')" ).append("\n"); 
		query.append("   	and bk.pol_cd                like @[pol_cd]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${next_port} !='')" ).append("\n"); 
		query.append("   	and next_vvd.pod_cd          like @[next_port]||'%'" ).append("\n"); 
		query.append("   #end   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${pod_cd} !='') " ).append("\n"); 
		query.append("   and bk.pod_cd                like @[pod_cd]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${next_vvd} !='')" ).append("\n"); 
		query.append("   	and next_vvd.vsl_cd          = substr(@[next_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_voy_no      = substr(@[next_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_dir_cd      = substr(@[next_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${next_vvd_select} !=''&&${next_vvd_select} != 'All')" ).append("\n"); 
		query.append("		#if(${next_vvd_select} == 'Assigned')" ).append("\n"); 
		query.append("			AND (NEXT_VVD.VSL_CD IS NOT NULL OR NEXT_VVD.VSL_CD <> 'COXX' OR NEXT_VVD.VSL_CD <> 'COYY' OR NEXT_VVD.VSL_CD <> 'COZZ')" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("		#if(${next_vvd_select} == 'Not Assigned')" ).append("\n"); 
		query.append("			AND (NEXT_VVD.VSL_CD IS NULL OR NEXT_VVD.VSL_CD = 'COXX' OR NEXT_VVD.VSL_CD = 'COYY' OR NEXT_VVD.VSL_CD = 'COZZ')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${rc_flg} !='')" ).append("\n"); 
		query.append("       and bk.rc_flg      = 'Y'  " ).append("\n"); 
		query.append("   #end	" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${dcgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.dcgo_flg    = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${awk_cgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${rd_cgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("order by etb, former_vvd" ).append("\n"); 

	}
}