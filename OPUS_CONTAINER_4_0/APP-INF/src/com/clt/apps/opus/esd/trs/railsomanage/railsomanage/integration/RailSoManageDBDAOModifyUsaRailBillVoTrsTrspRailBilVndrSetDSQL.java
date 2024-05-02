/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.20 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 SO를 SO Vendor 테이블에 삭제 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}