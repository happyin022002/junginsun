/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCmdtFakRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCmdtFakRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * F.A.K 여부 확인 (FAK, Cargo, NOS, GDSM)
	  * 2014.08.08 [CHM-201431477] GDSM 확인 추가
	  * 2015.10.27  TPE 로 미주 들어가는 경우 FAX 허용으로 예외 처리 수정
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCmdtFakRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCmdtFakRSQL").append("\n"); 
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
		query.append("#if( ${cmdt_cd} == '1' )" ).append("\n"); 
		query.append("-- REP_CMDT_CD 0000" ).append("\n"); 
		query.append("SELECT      case when @[cmdt_cd] = 4 then 'Y' --4는 전지역 가능" ).append("\n"); 
		query.append("                 when por.conti_cd <> 'A' and por.sconti_cd <> 'FS' then 'N' --origin이 asia이외 지역 4가 아니면 불가" ).append("\n"); 
		query.append("                 when SUBSTR(NVL(@[sc_no],'DUM'),1,3) <> 'DUM' and por.conti_cd  =  'A'  and (del.sconti_cd = 'MN' or del.sconti_cd = 'MC') then 'Y' --ASIA -> 북미는 전부 가능" ).append("\n"); 
		query.append("                 when SUBSTR(NVL(@[sc_no],'DUM'),1,3) <> 'DUM' and por.sconti_cd =  'FS' and (del.sconti_cd = 'MN' or del.sconti_cd = 'MC') then 'Y'" ).append("\n"); 
		query.append("--                 when por.conti_cd =  'A' and (del.sconti_cd <> 'MN' and del.sconti_cd <> 'MC') then 'N' --ASIA -> 북미 이외 지역은 4가 아니면 불가" ).append("\n"); 
		query.append("                 else 'N'" ).append("\n"); 
		query.append("            end result" ).append("\n"); 
		query.append("from MDM_location por" ).append("\n"); 
		query.append("   , MDM_location del" ).append("\n"); 
		query.append("where por.loc_cd = @[por_cd]" ).append("\n"); 
		query.append("  and del.loc_cd = @[del_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- REP_CMDT_CD 9901" ).append("\n"); 
		query.append("SELECT decode(result, 'N', rst, 'Y') result" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                  select case when por.conti_cd <> 'A' and por.sconti_cd <> 'FS' then 'N' --origin이 asia이외 지역 불가" ).append("\n"); 
		query.append("                              when SUBSTR(NVL(@[sc_no],'DUM'),1,3) <> 'DUM' and por.conti_cd  =  'A'  and (del.sconti_cd = 'MN' or del.sconti_cd = 'MC') then 'Y' --ASIA -> 북미는 전부 가능" ).append("\n"); 
		query.append("                              when SUBSTR(NVL(@[sc_no],'DUM'),1,3) <> 'DUM' and por.sconti_cd =  'FS' and (del.sconti_cd = 'MN' or del.sconti_cd = 'MC') then 'Y' " ).append("\n"); 
		query.append("--                              when por.conti_cd =  'A' and (del.sconti_cd <> 'MN' and del.sconti_cd <> 'MC') then 'N'--ASIA -> 북미 이외 지역은 4가 아니면 불가" ).append("\n"); 
		query.append("                              ELSE 'N'     " ).append("\n"); 
		query.append("                          end result" ).append("\n"); 
		query.append("                        , C.RST" ).append("\n"); 
		query.append("                     from MDM_location por" ).append("\n"); 
		query.append("                        , MDM_location del" ).append("\n"); 
		query.append("                        , (SELECT CASE  WHEN CMDT_CD = '000004' THEN 'Y'" ).append("\n"); 
		query.append("										WHEN REP_CMDT_CD = '0000' THEN 'N'" ).append("\n"); 
		query.append("										WHEN REP_CMDT_CD = '9901' " ).append("\n"); 
		query.append("											AND TO_DATE('20140810','YYYYMMDD') <= NVL(BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]), " ).append("\n"); 
		query.append("                                                                                     NVL(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(@[bkg_no], @[ca_flg]), SYSDATE)) " ).append("\n"); 
		query.append("											   THEN 'N'" ).append("\n"); 
		query.append("										ELSE 'Y'" ).append("\n"); 
		query.append("								  END RST " ).append("\n"); 
		query.append("                           FROM   MDM_COMMODITY" ).append("\n"); 
		query.append("                           WHERE  TO_CHAR(CMDT_CD) = TO_CHAR(@[cmdt_cd])" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) C" ).append("\n"); 
		query.append("                    where por.loc_cd = @[por_cd]" ).append("\n"); 
		query.append("                      and del.loc_cd = @[del_cd]" ).append("\n"); 
		query.append("                   ) A" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}