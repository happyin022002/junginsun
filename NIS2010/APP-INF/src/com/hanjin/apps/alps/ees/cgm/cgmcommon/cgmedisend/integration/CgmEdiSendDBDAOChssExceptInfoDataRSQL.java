/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOChssExceptInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOChssExceptInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHSS_EXCEPT 결정전 검색조건 조회
	  * 변수
	  * :bkg_no
	  * :cntr_no
	  * :ie_ind    - 'IP'  -- us import : 미국IMPORT, E : 미국EXPORT
	  * :tpsz_cd
	  * :loc_cd    - IMPORT 일때는 DEL_CD, EXPORT 일때는 POR_CD  
	  * :sc_no
	  * :eff_dt    - BKG 의 OC_DT 없으면 BKG_CRE_DT
	  * 
	  * 검색조건 :bkg_no  - SZP659764309 
	  *          :cntr_no - HJSU9434105
	  *          :ie_ind  - IP
	  * </pre>
	  */
	public CgmEdiSendDBDAOChssExceptInfoDataRSQL(){
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
		params.put("ie_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_ind",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOChssExceptInfoDataRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("      ,(SELECT CNTR_NO      FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]) CNTR_NO" ).append("\n"); 
		query.append("      ,(SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]) TPSZ_CD" ).append("\n"); 
		query.append("      ,@[ie_ind] IE_IND" ).append("\n"); 
		query.append("      ,@[final_ind] FINAL_IND" ).append("\n"); 
		query.append("      ,DECODE(@[ie_ind], 'IP', DEL_CD, 'XP', POR_CD, '') LOC_CD -- IMPORT 일때는 DEL_CD, EXPORT 일때는 POR_CD  " ).append("\n"); 
		query.append("      ,A.SC_NO" ).append("\n"); 
		query.append("      ,NVL((" ).append("\n"); 
		query.append("                    SELECT /*+ INDEX_DESC(B2 XAK11CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                           TO_CHAR(B2.CNMV_EVNT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                    FROM  CTM_MOVEMENT B2" ).append("\n"); 
		query.append("                    WHERE B2.CNTR_NO     =  @[cntr_no]" ).append("\n"); 
		query.append("                    AND   B2.BKG_NO      =  @[bkg_no]" ).append("\n"); 
		query.append("                    AND   B2.MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("                    AND   ROWNUM = 1      " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("              ,TO_CHAR(A.BKG_CRE_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("       EFF_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING  A" ).append("\n"); 
		query.append("WHERE BKG_NO =  @[bkg_no]" ).append("\n"); 

	}
}