/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyRailBilOrdBkgNoInclODSOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.02.24 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyRailBilOrdBkgNoInclODSOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OD/SO 를 포함한 모든 SO 의 bkg_no, bl_no  를 변경한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyRailBilOrdBkgNoInclODSOUSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyRailBilOrdBkgNoInclODSOUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("SET BKG_NO = NVL(@[bkg_no], A.BKG_NO)," ).append("\n"); 
		query.append("	BL_NO = NVL(@[bl_no], A.BL_NO)," ).append("\n"); 
		query.append("	BKG_NO_RVIS_FLG = DECODE(@[bkg_no], A.BKG_NO, NULL, 'Y')" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COP_NO = @[cop_no]" ).append("\n"); 

	}
}