/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.09.28 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Container List 를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchCntrListRSQL").append("\n"); 
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
		query.append("SELECT  CNTR.CNTR_NO cntr_no  ," ).append("\n"); 
		query.append("	NVL(MIN(SEAL.CNTR_SEAL_NO),'') CNTR_SEAL_NO," ).append("\n"); 
		query.append("	NVL(CNTR.CNTR_TPSZ_CD,'') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	NVL(BKG.BKG_CGO_TP_CD,'') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	DECODE(nvl(BKG.RC_FLG,'N'),'Y',1,'N','0') RC_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, BKG_VVD VVD, BKG_CONTAINER CNTR, BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND   VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND   VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = VVD.BKG_NO " ).append("\n"); 
		query.append("AND   BKG.BKG_NO IN (${ibflag})" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("              AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("              AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("AND   BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND   CNTR.BKG_NO = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND   CNTR.CNTR_NO = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("--AND   SEAL.CNTR_SEAL_SEQ(+) = '1'" ).append("\n"); 
		query.append("AND   (BKG.BKG_STS_CD = 'F' OR BKG.BKG_STS_CD = 'W')" ).append("\n"); 
		query.append("AND   BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND   BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("group by CNTR.CNTR_NO, CNTR.CNTR_TPSZ_CD, BKG.BKG_CGO_TP_CD, BKG.RC_FLG" ).append("\n"); 
		query.append("order by CNTR.CNTR_NO" ).append("\n"); 

	}
}