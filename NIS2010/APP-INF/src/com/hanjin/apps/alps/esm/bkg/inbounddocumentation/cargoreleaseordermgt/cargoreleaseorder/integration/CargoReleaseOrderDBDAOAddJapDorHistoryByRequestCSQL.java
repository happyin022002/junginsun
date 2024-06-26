/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddJapDorHistoryByRequestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2010.01.08 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddJapDorHistoryByRequestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddJapDorHistoryByRequestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_cng_evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddJapDorHistoryByRequestCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DO_HIS (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", DO_SEQ" ).append("\n"); 
		query.append(", DO_CNG_EVNT_CD" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append(", EVNT_DT" ).append("\n"); 
		query.append(", EVNT_GDT" ).append("\n"); 
		query.append(", EVNT_USR_ID" ).append("\n"); 
		query.append(", EVNT_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BDO.BKG_NO                 AS BKG_NO" ).append("\n"); 
		query.append(", NVL((SELECT /*+INDEX_DESC(T XPKBKG_DO_HIS) */ DO_SEQ" ).append("\n"); 
		query.append("FROM BKG_DO_HIS T" ).append("\n"); 
		query.append("WHERE T.BKG_NO = BDO.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM =1),0)+1 AS DO_SEQ" ).append("\n"); 
		query.append(", @[do_cng_evnt_cd]          AS DO_CNG_EVNT_CD" ).append("\n"); 
		query.append(", @[pre_ctnt]                AS PRE_CTNT" ).append("\n"); 
		query.append(", @[crnt_ctnt]               AS CRNT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC(@[evnt_ofc_cd])) AS EVNT_DT" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT') AS EVNT_GDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", @[evnt_usr_id]             AS EVNT_USR_ID" ).append("\n"); 
		query.append(", @[evnt_ofc_cd]             AS EVNT_OFC_CD" ).append("\n"); 
		query.append(", @[cre_usr_id]              AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                    AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]              AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE                    AS UPD_DT" ).append("\n"); 
		query.append("FROM BKG_DO BDO" ).append("\n"); 
		query.append("WHERE BDO.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND BDO.RLSE_SEQ = @[rlse_seq]" ).append("\n"); 

	}
}