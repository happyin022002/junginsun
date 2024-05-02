/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchFormerVvdSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.30 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchFormerVvdSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsl_nm,eta,etd 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchFormerVvdSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("relay_port_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("former_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchFormerVvdSkdRSQL").append("\n"); 
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
		query.append("select (select vsl_eng_nm from mdm_vsl_cntr mdm where mdm.vsl_cd = skd.vsl_cd) vsl_nm" ).append("\n"); 
		query.append(", to_char(vps_eta_dt, 'yyyy-mm-dd') eta" ).append("\n"); 
		query.append(", to_char(vps_etd_dt, 'yyyy-mm-dd') etd" ).append("\n"); 
		query.append("from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("where vsl_cd      = substr(@[former_vvd], 1, 4)" ).append("\n"); 
		query.append("and skd_voy_no  = substr(@[former_vvd], 5, 4)" ).append("\n"); 
		query.append("and skd_dir_cd  = substr(@[former_vvd], 9, 1)" ).append("\n"); 
		query.append("and vps_port_cd = @[relay_port]" ).append("\n"); 
		query.append("#if (${relay_port_yard_cd} !='')" ).append("\n"); 
		query.append("and yd_cd       = @[relay_port_yard_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}