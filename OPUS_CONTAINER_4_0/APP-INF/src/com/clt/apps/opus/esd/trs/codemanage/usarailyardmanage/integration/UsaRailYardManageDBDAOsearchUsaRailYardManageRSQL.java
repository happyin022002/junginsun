/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA Rail Yard 관리에서 리스트
	  * </pre>
	  */
	public UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.integration").append("\n"); 
		query.append("FileName : UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(YD.YD_CD, '') YD_CD," ).append("\n"); 
		query.append("NVL(YD.YD_NM, '') YD_NM," ).append("\n"); 
		query.append("NVL(YD.YD_LOC_CTY_NM, ' ') YD_LOC_CTY_NM," ).append("\n"); 
		query.append("NVL(YD.YD_LOC_STE_CD,' ') YD_LOC_STE_CD," ).append("\n"); 
		query.append("DECODE(YD.YD_CTRL_OFC_ADDR, NULL, SUBSTR(UPPER(SUBSTR(ORG.OFC_ADDR, 1," ).append("\n"); 
		query.append("DECODE(INSTR(ORG.OFC_ADDR,'@*'), 0, 100, INSTR(ORG.OFC_ADDR,'@*')-1))),1,35)," ).append("\n"); 
		query.append("YD.YD_CTRL_OFC_ADDR) YD_CTRL_OFC_ADDR," ).append("\n"); 
		query.append("DECODE(YD.YD_CTRL_OFC_CTY_NM, NULL, SUBSTR(UPPER(SUBSTR(LOC.LOC_NM, 1," ).append("\n"); 
		query.append("DECODE(INSTR(LOC.LOC_NM,','), 0, 30, INSTR(LOC.LOC_NM,',')-1))),1,30)," ).append("\n"); 
		query.append("YD.YD_CTRL_OFC_CTY_NM) YD_CTRL_OFC_CTY_NM," ).append("\n"); 
		query.append("DECODE(YD.YD_CTRL_OFC_STE_CD, NULL, UPPER(LOC.STE_CD), YD.YD_CTRL_OFC_STE_CD) YD_CTRL_OFC_STE_CD," ).append("\n"); 
		query.append("DECODE(YD.YD_CTRL_OFC_ZIP_CD, NULL, ORG.OFC_ZIP_CD, YD.YD_CTRL_OFC_ZIP_CD) YD_CTRL_OFC_ZIP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_YARD YD," ).append("\n"); 
		query.append("MDM_LOCATION LOC," ).append("\n"); 
		query.append("MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("WHERE   YD.OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("AND     YD.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("#if(${yard} != '')" ).append("\n"); 
		query.append("#if( $yard.length() == 5)" ).append("\n"); 
		query.append("AND YD.YD_CD LIKE @[yard]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND YD.YD_CD = @[yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}