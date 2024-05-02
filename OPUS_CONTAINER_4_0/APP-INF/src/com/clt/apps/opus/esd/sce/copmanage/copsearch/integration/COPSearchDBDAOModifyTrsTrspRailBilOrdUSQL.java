/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOUpdateTrsTrspRailBilOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.01 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOModifyTrsTrspRailBilOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop inquiry
	  * </pre>
	  */
	public COPSearchDBDAOModifyTrsTrspRailBilOrdUSQL(){
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration ").append("\n"); 
		query.append("FileName : COPSearchDBDAOUpdateTrsTrspRailBilOrdUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_rail_bil_ord" ).append("\n"); 
		query.append("SET cop_no =  @[cop_no]" ).append("\n"); 
		query.append(", bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("WHERE trsp_so_ofc_cty_cd =  @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND trsp_so_seq =  @[trsp_so_seq]" ).append("\n"); 

	}
}