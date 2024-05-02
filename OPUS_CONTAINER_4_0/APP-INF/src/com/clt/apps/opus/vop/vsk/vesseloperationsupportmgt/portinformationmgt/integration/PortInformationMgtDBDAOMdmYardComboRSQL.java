/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAOMdmYardComboRSQL.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.19 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOMdmYardComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy Combo
	  * </pre>
	  */
	public PortInformationMgtDBDAOMdmYardComboRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("my.yd_cd AS val" ).append("\n"); 
		query.append(",   my.yd_nm AS name" ).append("\n"); 
		query.append(",   '' AS df" ).append("\n"); 
		query.append("FROM mdm_yard     my" ).append("\n"); 
		query.append(",    mdm_location ml" ).append("\n"); 
		query.append("WHERE my.loc_cd	=	ml.loc_cd" ).append("\n"); 
		query.append("AND my.loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("AND my.yd_cd NOT IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("my.yd_cd" ).append("\n"); 
		query.append("FROM vsk_port_mnvr vpm" ).append("\n"); 
		query.append(",    mdm_yard my" ).append("\n"); 
		query.append("WHERE vpm.yd_cd = my.yd_cd" ).append("\n"); 
		query.append("AND my.loc_cd = @[loc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VAL ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOMdmYardComboRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}