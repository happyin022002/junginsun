/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchLclMibFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2010.01.04 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchLclMibFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim,  Partial Check쿼리
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchLclMibFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchLclMibFlagRSQL").append("\n"); 
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
		query.append("SELECT A.bl_no" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL A, BKG_CSTMS_ADV_IBD A1, BKG_CSTMS_ADV_CNTR B, BKG_CSTMS_ADV_CNTR C, BKG_CSTMS_ADV_BL D, BKG_CSTMS_ADV_IBD D1, BKG_CGO_RLSE CR" ).append("\n"); 
		query.append("WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND A.vsl_cd        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.skd_voy_no   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.skd_dir_cd   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.POD_CD       = @[pod]" ).append("\n"); 
		query.append("AND A.HUB_LOC_CD   = @[hub]" ).append("\n"); 
		query.append("AND A.DEL_CD       = @[del]" ).append("\n"); 
		query.append("AND A.CNT_CD = A1.CNT_CD" ).append("\n"); 
		query.append("AND A.BL_NO = A1.BL_NO" ).append("\n"); 
		query.append("AND A.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("AND B.CNT_CD         = A.CNT_CD" ).append("\n"); 
		query.append("AND B.bl_no         = A.bl_no" ).append("\n"); 
		query.append("AND A.MF_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND D.vsl_cd       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND D.skd_voy_no   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND D.skd_dir_cd   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND D.POD_CD       = @[pod]" ).append("\n"); 
		query.append("AND D.HUB_LOC_CD   = @[hub]" ).append("\n"); 
		query.append("AND D.DEL_CD       = @[del]" ).append("\n"); 
		query.append("AND D.CNT_CD = D1.CNT_CD" ).append("\n"); 
		query.append("AND D.BL_NO = D1.BL_NO" ).append("\n"); 
		query.append("AND D.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("AND D.CNT_CD         = C.CNT_CD" ).append("\n"); 
		query.append("AND D.bl_no         = C.bl_no" ).append("\n"); 
		query.append("AND D.MF_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.cnt_cd        = B.cnt_cd" ).append("\n"); 
		query.append("AND C.cntr_no       = B.cntr_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND D.bl_no <> A.bl_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.bl_no = CR.bl_no(+)" ).append("\n"); 
		query.append("AND A.BL_NO = NVl(@[bl_no], A.BL_NO)" ).append("\n"); 
		query.append("AND (CR.CSTMS_CLR_CD <> 'Y' or CR.CSTMS_CLR_CD is null)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}