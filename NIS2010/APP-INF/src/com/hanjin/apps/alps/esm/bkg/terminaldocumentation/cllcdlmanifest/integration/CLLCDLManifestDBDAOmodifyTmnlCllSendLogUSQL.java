/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOmodifyTmnlCllSendLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOmodifyTmnlCllSendLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyTmnlCllSendLog
	  * </pre>
	  */
	public CLLCDLManifestDBDAOmodifyTmnlCllSendLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_etc_euid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOmodifyTmnlCllSendLogUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_TML_CLL SET" ).append("\n"); 
		query.append("	SND_DT = SYSDATE," ).append("\n"); 
		query.append("	FLT_FILE_REF_NO = @[in_etc_euid]," ).append("\n"); 
		query.append("	EDI_RCV_STS_CD = 'W'" ).append("\n"); 
		query.append("WHERE	VSL_CD	= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	PORT_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("#if(${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(CLPT_IND_SEQ, '1') = @[in_pol_split_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 

	}
}