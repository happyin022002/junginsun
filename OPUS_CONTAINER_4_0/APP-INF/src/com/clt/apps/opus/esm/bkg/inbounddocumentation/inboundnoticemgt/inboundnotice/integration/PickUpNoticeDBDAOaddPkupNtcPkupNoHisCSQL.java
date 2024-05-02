/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcPkupNoHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 e-Mail File Import를 통해  Pick-up No 정보를 추가하거나, 직접 입력 하거나, EDI를 통해 입력될 때 이력 정보 관리
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcPkupNoHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_NTC_PKUP_NO_HIS (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	HIS_SEQ" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	PKUP_NO" ).append("\n"); 
		query.append(",	PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	LST_FREE_DT" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	PKUP_CRE_DT" ).append("\n"); 
		query.append(",	PKUP_CRE_USR_ID" ).append("\n"); 
		query.append(",	PKUP_UPD_DT" ).append("\n"); 
		query.append(",	PKUP_UPD_USR_ID" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	PKUP_DELT_DT" ).append("\n"); 
		query.append(",	PKUP_DELT_USR_ID" ).append("\n"); 
		query.append(",	PKUP_DELT_RSN" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	RAIL_ARR_DT" ).append("\n"); 
		query.append(",	RAIL_DEP_DT" ).append("\n"); 
		query.append(",	PKUP_MNL_UPLD_FLG" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	A.BKG_NO" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.OFC_CD" ).append("\n"); 
		query.append(",	NVL((SELECT /*+INDEX_DESC(T XPKBKG_PKUP_NTC_PKUP_NO_HIS)*/ HIS_SEQ " ).append("\n"); 
		query.append("         FROM   BKG_PKUP_NTC_PKUP_NO_HIS T" ).append("\n"); 
		query.append("         WHERE  BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("         AND    CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("         AND    OFC_CD  = A.OFC_CD" ).append("\n"); 
		query.append("         AND    ROWNUM  = 1),0) + 1" ).append("\n"); 
		query.append(",	A.BL_NO" ).append("\n"); 
		query.append(",	A.VSL_CD" ).append("\n"); 
		query.append(",	A.SKD_VOY_NO" ).append("\n"); 
		query.append(",	A.SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.POD_CD" ).append("\n"); 
		query.append(",	A.DEL_CD" ).append("\n"); 
		query.append(",	A.DE_TERM_CD" ).append("\n"); 
		query.append(",	A.RAIL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	A.IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append(",	A.PKUP_YD_CD" ).append("\n"); 
		query.append(",	A.PKUP_NO" ).append("\n"); 
		query.append(",	A.PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	A.LST_FREE_DT" ).append("\n"); 
		query.append(",	A.RTN_YD_CD" ).append("\n"); 
		query.append(",	A.PKUP_CRE_DT" ).append("\n"); 
		query.append(",	A.PKUP_CRE_USR_ID" ).append("\n"); 
		query.append(",	A.PKUP_UPD_DT" ).append("\n"); 
		query.append(",	A.PKUP_UPD_USR_ID" ).append("\n"); 
		query.append(",	A.DELT_FLG" ).append("\n"); 
		query.append(",	A.PKUP_DELT_DT" ).append("\n"); 
		query.append(",	A.PKUP_DELT_USR_ID" ).append("\n"); 
		query.append(",	''  AS PKUP_DELT_RSN" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	A.RAIL_ARR_DT" ).append("\n"); 
		query.append(",	A.RAIL_DEP_DT" ).append("\n"); 
		query.append(",	A.PKUP_MNL_UPLD_FLG" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC_PKUP_NO A" ).append("\n"); 
		query.append("WHERE A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   A.OFC_CD  = @[ofc_cd]" ).append("\n"); 

	}
}