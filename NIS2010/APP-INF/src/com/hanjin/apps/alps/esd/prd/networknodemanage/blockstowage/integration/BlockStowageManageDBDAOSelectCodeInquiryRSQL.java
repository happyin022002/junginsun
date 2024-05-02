/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BlockStowageManageDBDAOSelectCodeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlockStowageManageDBDAOSelectCodeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectCodeInquiry
	  * </pre>
	  */
	public BlockStowageManageDBDAOSelectCodeInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.integration").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOSelectCodeInquiryRSQL").append("\n"); 
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
		query.append("SELECT distinct a.port_cd port_code" ).append("\n"); 
		query.append("	, a.vsl_slan_cd lane_code" ).append("\n"); 
		query.append("	, a.hub_loc_cd hub_code" ).append("\n"); 
		query.append("	, a.blck_stwg_cd bs_code" ).append("\n"); 
		query.append("	, substr(B.rout_dest_nod_cd, 0, 5) dest" ).append("\n"); 
		query.append("FROM prd_blck_stwg a, prd_inlnd_rout_mst b" ).append("\n"); 
		query.append("WHERE a.port_cd = substr(b.rout_org_nod_cd,1,5)" ).append("\n"); 
		query.append("AND a.hub_loc_cd = DECODE(substr(b.hub_nod_cd,1,5),NULL,substr(b.rout_org_nod_cd,1,5),substr(b.hub_nod_cd,1,5))" ).append("\n"); 
		query.append("AND b.inlnd_rout_bkg_flg ='Y'" ).append("\n"); 
		query.append("AND NVL(a.delt_flg, 'N') <>'Y'" ).append("\n"); 
		query.append("AND NVL(b.delt_flg, 'N') <>'Y'" ).append("\n"); 
		query.append("AND a.port_cd LIKE @[port_code] || '%'" ).append("\n"); 
		query.append("AND a.vsl_slan_cd LIKE @[lane_code] || '%'" ).append("\n"); 
		query.append("AND a.hub_loc_cd LIKE @[hub_code] || '%'" ).append("\n"); 
		query.append("AND a.blck_stwg_cd LIKE @[bs_code] || '%'" ).append("\n"); 
		query.append("AND b.rout_dest_nod_cd LIKE @[dest] || '%'" ).append("\n"); 
		query.append("AND b.pctl_io_bnd_cd = 'I'" ).append("\n"); 
		query.append("AND a.stwg_cd <> 'ALL'" ).append("\n"); 

	}
}