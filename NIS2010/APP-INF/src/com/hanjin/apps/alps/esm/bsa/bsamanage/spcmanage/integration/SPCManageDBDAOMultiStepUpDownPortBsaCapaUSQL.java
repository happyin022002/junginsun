/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_Inquery_vvd에서 crr_cd에 값을 변경 한 경우 bsa_vvd_port_dwn 의 CRR_CD에 해당 하는 값을 변경 작업 수행
	  * DAO에서 두번 작업을 실행시켜야 함.
	  * 1. SML Final 값을 변경
	  * 2. 변경한 Crr_cd 값 변경
	  *   이때 JO / 000 인 경우 와 아닌 경우로 구분하여 처리 함.
	  * 
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("def_value",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa_sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL").append("\n"); 
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
		query.append("UPDATE BSA_VVD_PORT_DWN" ).append("\n"); 
		query.append("##if (${type} == 'JO' && ${crr_cd} == 'SML')" ).append("\n"); 
		query.append("#if (${crr_cd} == 'SML')" ).append("\n"); 
		query.append("-- JO/SC , SML FINAL 값 적용 , 모든 CRR의 값 변경시 타야함." ).append("\n"); 
		query.append("#if (${type} == 'SC')" ).append("\n"); 
		query.append("   SET PORT_BSA_CAPA = @[fnl_hjs_bsa_capa_sc]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   SET PORT_BSA_CAPA = @[fnl_hjs_bsa_capa]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${type} == 'JO' && ${bsa_op_jb_cd} != '000')" ).append("\n"); 
		query.append("-- JO / CRR값 적용 SML Vessel 변경시 - OWN인 경우 (2015.02W, TPS,PSGTP,HJXM0046W에서 HMM 변경)" ).append("\n"); 
		query.append(" #if (${crr_cd} == ${car_cd} ) ### 운항주체와 변경한 선사 값이 동일한 경우 해당 선사의 원래 정보에서 변경된 만큼의 수량을 더함" ).append("\n"); 
		query.append(" SET PORT_BSA_CAPA = (" ).append("\n"); 
		query.append("		SELECT PORT_BSA_CAPA  + TO_NUMBER(@[def_value])" ).append("\n"); 
		query.append("    	FROM bsa_vvd_port_dwn" ).append("\n"); 
		query.append("	    WHERE   trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("        	AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("        	AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("        	AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("        	AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("        	AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("        	AND crr_cd       = @[crr_cd]" ).append("\n"); 
		query.append("        	AND PORT_SEQ      = 999 )" ).append("\n"); 
		query.append(" #else ### 운항주체와 변경한 선사 값이 다른 경우 해당 선사의 원래 정보에서 변경된 만큼의 수량을 더함" ).append("\n"); 
		query.append(" SET PORT_BSA_CAPA = PORT_BSA_CAPA + TO_NUMBER(@[def_value])" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- JO / CRR값 적용 SML Vessel 변경시 - OWN인 경우 (2015.01W, AES,CFNAE,CSJP0036E에서 UAC 변경)" ).append("\n"); 
		query.append("-- SET PORT_BSA_CAPA = @ [crr_bsa_capa]" ).append("\n"); 
		query.append(" SET PORT_BSA_CAPA = PORT_BSA_CAPA + TO_NUMBER(@[def_value])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("###elseif (${type} == 'JO' && ${crr_cd} != 'SML')" ).append("\n"); 
		query.append("##-- JO / CRR 값 적용 / OTHER VESSELS -- 적용 값 , OTH인 경우 (2015.03W, TPS,PSGTP,NYAQ0066E에서 NYK 변경)" ).append("\n"); 
		query.append("## SET PORT_BSA_CAPA = ( " ).append("\n"); 
		query.append("##        SELECT (" ).append("\n"); 
		query.append("##            (" ).append("\n"); 
		query.append("##			-- 현재 crr_cd의 값" ).append("\n"); 
		query.append("##            select PORT_BSA_CAPA from bsa_vvd_port_dwn" ).append("\n"); 
		query.append("##            where trd_cd       = @ [trd_cd]" ).append("\n"); 
		query.append("##			    AND rlane_cd     = @ [lane_cd]" ).append("\n"); 
		query.append("##			    AND vsl_cd       = @ [vsl_cd]" ).append("\n"); 
		query.append("##			    AND skd_voy_no   = @ [voy_no]" ).append("\n"); 
		query.append("##			    AND skd_dir_cd   = @ [dir_cd]" ).append("\n"); 
		query.append("##			    AND bsa_op_jb_cd = @ [jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("##			    AND crr_cd       = @ [crr_cd]" ).append("\n"); 
		query.append("##            	AND PORT_SEQ = '999'" ).append("\n"); 
		query.append("##            ) - (" ).append("\n"); 
		query.append("##			-- 변경 한 값에서 변경 전 값을 뺀서 증감분을 만든다" ).append("\n"); 
		query.append("##            @ [fnl_hjs_bsa_capa] - ( ## @ [crr_bsa_capa]" ).append("\n"); 
		query.append("##                select PORT_BSA_CAPA from bsa_vvd_port_dwn" ).append("\n"); 
		query.append("##                where trd_cd         = @ [trd_cd]" ).append("\n"); 
		query.append("##				    AND rlane_cd     = @ [lane_cd]" ).append("\n"); 
		query.append("##				    AND vsl_cd       = @ [vsl_cd]" ).append("\n"); 
		query.append("##				    AND skd_voy_no   = @ [voy_no]" ).append("\n"); 
		query.append("##    				AND skd_dir_cd   = @ [dir_cd]" ).append("\n"); 
		query.append("##				    AND bsa_op_jb_cd = @ [jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("##                	AND CRR_CD = 'SML'  --고정값 / " ).append("\n"); 
		query.append("##	                AND PORT_SEQ = '999'" ).append("\n"); 
		query.append("##                )" ).append("\n"); 
		query.append("##            )" ).append("\n"); 
		query.append("##            )" ).append("\n"); 
		query.append("##        FROM DUAL" ).append("\n"); 
		query.append("##    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("    AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("    AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("    AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("    AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("    AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("    AND crr_cd       = @[crr_cd]" ).append("\n"); 
		query.append("    AND PORT_BSA_CAPA      = ( -- 현재 항차의 VVD / CRR 의 변경 전 값" ).append("\n"); 
		query.append("		SELECT PORT_BSA_CAPA " ).append("\n"); 
		query.append("    	FROM bsa_vvd_port_dwn" ).append("\n"); 
		query.append("	    WHERE   trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("        	AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("        	AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("        	AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("        	AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("        	AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("        	AND crr_cd       = @[crr_cd]" ).append("\n"); 
		query.append("        	AND PORT_SEQ      = 999  --*" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	AND ( PORT_SEQ      = 999 )" ).append("\n"); 
		query.append("    OR ( trd_cd       = @[trd_cd]" ).append("\n"); 
		query.append("    	AND rlane_cd     = @[lane_cd]" ).append("\n"); 
		query.append("    	AND vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("    	AND skd_voy_no   = @[voy_no]" ).append("\n"); 
		query.append("	    AND skd_dir_cd   = @[dir_cd]" ).append("\n"); 
		query.append("	    AND bsa_op_jb_cd = @[jb_cd] -- BSA : 007, Slot Price : 015" ).append("\n"); 
		query.append("	    AND crr_cd       = @[crr_cd] " ).append("\n"); 
		query.append("    	AND PORT_SEQ      <> 999 " ).append("\n"); 
		query.append("		AND PORT_BSA_CAPA > 0 " ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}