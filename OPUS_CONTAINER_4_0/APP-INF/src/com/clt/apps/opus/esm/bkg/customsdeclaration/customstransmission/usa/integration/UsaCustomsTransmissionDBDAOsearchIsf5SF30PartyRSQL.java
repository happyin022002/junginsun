/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchIsf5SF30PartyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchIsf5SF30PartyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, isf5전송관련, SF30Party, 연관 VO : UsaIsf5ResultVO, vo생성금지.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchIsf5SF30PartyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchIsf5SF30PartyRSQL").append("\n"); 
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
		query.append("SELECT BKG_SPCLCHAR_CONV_FNC(RPAD(SCE_TOKEN_NL_FNC(RTRIM(CC.CUST_NM),1),35,' '),'M') ENTT_NAME" ).append("\n"); 
		query.append("      ,BKG_SPCLCHAR_CONV_FNC(RPAD(SCE_TOKEN_NL_FNC(RTRIM(CC.CUST_ADDR),1),35,' '),'M') ADD_INFO" ).append("\n"); 
		query.append("      ,BKG_SPCLCHAR_CONV_FNC(RPAD(NVL(SCE_TOKEN_NL_FNC(RTRIM(CC.CUST_ADDR),2),'.'),35,' '),'M') ADD_INFO_2" ).append("\n"); 
		query.append("      ,BKG_SPCLCHAR_CONV_FNC(RPAD(SUBSTR(DECODE(RTRIM(CC.CUST_CTY_NM), NULL, DECODE(RTRIM(BC.CUST_CTY_NM), NULL, L1.LOC_NM, RTRIM(BC.CUST_CTY_NM)), RTRIM(CC.CUST_CTY_NM)),1,35),35,' '),'M') ADD_CT" ).append("\n"); 
		query.append("      ,BKG_SPCLCHAR_CONV_FNC(RPAD(DECODE(RTRIM(CC.CUST_CNT_CD), NULL, DECODE(RTRIM(BC.CUST_CNT_CD), NULL, SUBSTR(CB.POD_CD,1,2), RTRIM(BC.CUST_CNT_CD)), RTRIM(CC.CUST_CNT_CD)),2,' '),'M') ADD_CNTRY" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL CB" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST CC" ).append("\n"); 
		query.append("      ,BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("      ,MDM_LOCATION L1" ).append("\n"); 
		query.append(" WHERE CB.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND CB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND CB.CNT_CD = CC.CNT_CD" ).append("\n"); 
		query.append("   AND CB.BL_NO = CC.BL_NO" ).append("\n"); 
		query.append("   AND CC.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("   AND CB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("   AND BC.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("   AND CB.POD_CD   = L1.LOC_CD" ).append("\n"); 

	}
}