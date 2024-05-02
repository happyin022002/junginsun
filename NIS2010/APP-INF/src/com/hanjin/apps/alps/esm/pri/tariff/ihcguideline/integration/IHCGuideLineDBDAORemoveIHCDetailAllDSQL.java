/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAORemoveIHCDetailAllDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAORemoveIHCDetailAllDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 엑셀 업로드 시 업데이트 되지 않은 route를 삭제한다.
	  * </pre>
	  */
	public IHCGuideLineDBDAORemoveIHCDetailAllDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAORemoveIHCDetailAllDSQL").append("\n"); 
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
		query.append("DELETE FROM  PRI_TRF_IHC_RT " ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("   AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("   AND IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("   AND (IHC_RT_RMK IS NULL OR OPTM_TRSP_MOD_FLG = 'N')" ).append("\n"); 

	}
}