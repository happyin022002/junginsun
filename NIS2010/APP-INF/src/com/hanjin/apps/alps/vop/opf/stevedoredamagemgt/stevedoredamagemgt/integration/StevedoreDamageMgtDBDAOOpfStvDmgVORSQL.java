/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.16 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgVORSQL").append("\n"); 
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
		query.append("STV_DMG_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	TO_CHAR(STV_DMG_EVNT_DT, 'YYYY-MM-DD') AS STV_DMG_EVNT_DT" ).append("\n"); 
		query.append(",	VSL_OSHP_CNTR_BLK_TP_CD" ).append("\n"); 
		query.append(",	STV_DMG_REF_NO" ).append("\n"); 
		query.append(",	CLM_HNDL_OFC_CD" ).append("\n"); 
		query.append(",	DMG_AUTH_STS_CD" ).append("\n"); 
		query.append(",	AUTH_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(AUTH_DT, 'YYYY-MM-DD') AS AUTH_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 

	}
}