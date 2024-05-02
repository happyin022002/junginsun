/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoHisByBkgNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.05.11 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcPkupNoHisByBkgNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcPkupNoHisByBkgNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcPkupNoHisByBkgNoCSQL").append("\n"); 
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
		query.append("/* 삭제됨!!!!!" ).append("\n"); 
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
		query.append("    ,BKG_PKUP_NTC         B" ).append("\n"); 
		query.append("    ,BKG_BOOKING          C" ).append("\n"); 
		query.append("    ,MDM_LOCATION         D" ).append("\n"); 
		query.append("WHERE B.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND   B.NTC_SEQ = @[ntc_seq]" ).append("\n"); 
		query.append("AND   C.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("AND   D.LOC_CD  = C.DEL_CD" ).append("\n"); 
		query.append("AND   A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("AND   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND   A.OFC_CD  = D.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}