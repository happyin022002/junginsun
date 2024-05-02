/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.06
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.05.06 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유효한 마지막 version
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionRSQL").append("\n"); 
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
		query.append("SELECT  NVL(MAX(JO_VER_NO), 0)  AS OLD_JO_VER_NO" ).append("\n"); 
		query.append("  FROM  JOO_BSA_INFO_ENTR" ).append("\n"); 
		query.append(" WHERE  VSL_CD     =  @[vsl_cd]" ).append("\n"); 
		query.append("   AND  SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  PORT_CD    =  @[port_cd]" ).append("\n"); 
		query.append("   AND  PORT_SEQ   =  @[port_seq]" ).append("\n"); 
		query.append("   AND  JO_CRR_CD  =  @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND  RLANE_CD   =  @[rlane_cd]" ).append("\n"); 
		query.append("   AND  JO_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND  DELT_FLG   = 'N'" ).append("\n"); 

	}
}