/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGSaDtForTvvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.22 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ManualARCreationDBDAOsearchBKGSaDtForTvvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGSaDtForTvvd
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGSaDtForTvvdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  DECODE(DECODE(@[bnd], 'O', VPS_ETD_DT, VPS_ETA_DT), NULL," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD')," ).append("\n"); 
		query.append("TO_CHAR(DECODE(@[bnd], 'O', VPS_ETD_DT, VPS_ETA_DT),'YYYY-MM-DD')) SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD ," ).append("\n"); 
		query.append("(SELECT DECODE(@[bnd], 'O', MAX(CLPT_IND_SEQ), MIN(CLPT_IND_SEQ)) X_CALL_IND" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD = SUBSTR(@[vvl_cd],1,4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvl_cd],5,4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvl_cd],9,1)" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("AND    VPS_PORT_CD = @[port_cd] )" ).append("\n"); 
		query.append("WHERE  VSL_CD = SUBSTR(@[vvl_cd],1,4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvl_cd],5,4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvl_cd],9,1)" ).append("\n"); 
		query.append("AND    CLPT_IND_SEQ = X_CALL_IND" ).append("\n"); 
		query.append("AND    VPS_PORT_CD = @[port_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGSaDtForTvvdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}