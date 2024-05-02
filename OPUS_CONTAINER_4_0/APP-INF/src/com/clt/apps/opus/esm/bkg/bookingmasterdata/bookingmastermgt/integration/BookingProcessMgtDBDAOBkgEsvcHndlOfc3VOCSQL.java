/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.24 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create >>> bkg_esvc_ofc_eml
	  * </pre>
	  */
	public BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ntfc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_ntfc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_ESVC_OFC_EML (" ).append("\n"); 
		query.append("HNDL_OFC_CD" ).append("\n"); 
		query.append(",	HNDL_OFC_SEQ" ).append("\n"); 
		query.append(",	SI_NTFC_EML" ).append("\n"); 
		query.append(",	BKG_NTFC_EML" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[hndl_ofc_cd]" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(HNDL_OFC_SEQ),0)+1 FROM BKG_ESVC_OFC_EML)" ).append("\n"); 
		query.append(",	@[si_ntfc_eml]" ).append("\n"); 
		query.append(",	@[bkg_ntfc_eml]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingprocessmgt.integration ").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfc3VOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}