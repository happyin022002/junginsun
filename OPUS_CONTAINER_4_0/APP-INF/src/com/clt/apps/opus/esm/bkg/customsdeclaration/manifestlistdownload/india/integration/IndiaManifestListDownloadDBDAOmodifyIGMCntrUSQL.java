/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOmodifyIGMCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.18 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOmodifyIGMCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 인도세관 테이블에 컨테이너정보를 수정한다.
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOmodifyIGMCntrUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_stwg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE BKG_CSTMS_IDA_CNTR SET" ).append("\n"); 
		query.append("IDA_STWG_NO = @[ida_stwg_no]" ).append("\n"); 
		query.append("WHERE	VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	CNTR_NO = @[cntr_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOmodifyIGMCntrUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}