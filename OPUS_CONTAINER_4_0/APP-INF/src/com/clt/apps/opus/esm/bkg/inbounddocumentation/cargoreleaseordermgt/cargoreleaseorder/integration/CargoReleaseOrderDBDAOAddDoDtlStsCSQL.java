/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddDoDtlStsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddDoDtlStsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O 상세 정보를 저장한다.(DO Staus 변환시마다 정보를 저장한다)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddDoDtlStsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlse_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddDoDtlStsCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DO_DTL (" ).append("\n"); 
		query.append(" BKG_NO" ).append("\n"); 
		query.append("  , RLSE_SEQ" ).append("\n"); 
		query.append("  , RLSE_STS_SEQ" ).append("\n"); 
		query.append("  , RLSE_STS_CD" ).append("\n"); 
		query.append("  , EVNT_DT" ).append("\n"); 
		query.append("  , EVNT_USR_ID" ).append("\n"); 
		query.append("  , EVNT_OFC_CD" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[bkg_no]" ).append("\n"); 
		query.append("     , NVL( @[rlse_seq],1 )" ).append("\n"); 
		query.append("     , NVL((SELECT /*+INDEX_DESC(T XPKBKG_DO_DTL) */ RLSE_STS_SEQ" ).append("\n"); 
		query.append("             FROM BKG_DO_DTL T" ).append("\n"); 
		query.append("            WHERE T.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND T.RLSE_SEQ = NVL( @[rlse_seq],1 )" ).append("\n"); 
		query.append("              AND ROWNUM = 1) , 0) +1" ).append("\n"); 
		query.append("     , @[rlse_sts_cd]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC(@[evnt_ofc_cd]))" ).append("\n"); 
		query.append("     , @[evnt_usr_id]" ).append("\n"); 
		query.append("     , @[evnt_ofc_cd]" ).append("\n"); 
		query.append("     , @[evnt_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}