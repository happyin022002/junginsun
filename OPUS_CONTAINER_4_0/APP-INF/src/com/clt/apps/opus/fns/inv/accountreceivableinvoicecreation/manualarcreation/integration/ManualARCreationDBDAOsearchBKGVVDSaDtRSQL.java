/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGVVDSaDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.23 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBKGVVDSaDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGVVDSaDt
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGVVDSaDtRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("SELECT NVL(A.VSL_CD, '') VSL_CD, NVL(A.SKD_VOY_NO, '') SKD_VOY_NO, NVL(A.SKD_DIR_CD, '') SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(DECODE(@[bnd], 'O', B.VPS_ETD_DT, B.VPS_ETA_DT), NULL, TO_CHAR(B.VPS_ETB_DT, 'YYYY-MM-DD'), TO_CHAR(DECODE(@[bnd], 'O', B.VPS_ETD_DT, B.VPS_ETA_DT),'YYYY-MM-DD')) SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM   BKG_VVD A,  VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("(SELECT BV.VSL_PRE_PST_CD X_BV_IND, DECODE(@[bnd], 'O', MAX(VPS.CLPT_IND_SEQ), MIN(VPS.CLPT_IND_SEQ)) X_CALL_IND" ).append("\n"); 
		query.append("FROM   BKG_VVD BV , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE  BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    DECODE(@[bnd], 'O', BV.POL_CD, BV.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND    BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("AND    BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    DECODE(@[bnd], 'O', BV.POL_CD, BV.POD_CD) = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    NVL(VPS.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("GROUP BY BV.VSL_PRE_PST_CD, VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("VPS.VPS_PORT_CD )" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    DECODE(@[bnd], 'O', A.POL_CD, A.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND    A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    DECODE(@[bnd], 'O', A.POL_CD, A.POD_CD) = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    B.CLPT_IND_SEQ  = X_CALL_IND" ).append("\n"); 
		query.append("AND    A.VSL_PRE_PST_CD  = X_BV_IND" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGVVDSaDtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}