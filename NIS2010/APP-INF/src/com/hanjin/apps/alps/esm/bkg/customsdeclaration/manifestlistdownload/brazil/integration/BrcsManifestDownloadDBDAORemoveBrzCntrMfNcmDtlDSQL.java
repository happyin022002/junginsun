/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAORemoveBrzCntrMfNcmDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAORemoveBrzCntrMfNcmDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.09.14 변종건 [CHM-201217819-01] Brazil Customs에 대한 Multi NCM Code 전송 Test를 위한 Flat File 생성 요청
	  *  - BKG_CSTMS_BRZ_CNTR_MF_DTL 테이블 Delete
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAORemoveBrzCntrMfNcmDtlDSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAORemoveBrzCntrMfNcmDtlDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_BRZ_CNTR_MF_DTL" ).append("\n"); 
		query.append("WHERE   BL_NO       = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("AND     CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_MF_SEQ = @[cntr_mf_seq]" ).append("\n"); 

	}
}