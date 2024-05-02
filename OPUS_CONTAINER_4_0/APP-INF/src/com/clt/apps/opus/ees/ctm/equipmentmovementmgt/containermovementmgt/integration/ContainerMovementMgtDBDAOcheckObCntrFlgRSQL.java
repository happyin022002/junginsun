/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckObCntrFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckObCntrFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkObCntrFlg
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckObCntrFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckObCntrFlgRSQL").append("\n"); 
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
		query.append("SELECT 'A' AS EXIST" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("       , BKG_VVD BV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CTM.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("   AND BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CTM.CRNT_VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("   AND CTM.CRNT_SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND CTM.CRNT_SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 

	}
}