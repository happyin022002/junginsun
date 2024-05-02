/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchMtyCntrReserveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.30 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchMtyCntrReserveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cntr가 이미 다른 Booking에 예약중인지 확인
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchMtyCntrReserveRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchMtyCntrReserveRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM (SELECT BK.BKG_NO" ).append("\n"); 
		query.append("FROM bkg_container cntr" ).append("\n"); 
		query.append(", bkg_BOOKING Bk" ).append("\n"); 
		query.append("WHERE cntr.cntr_no     = @[cntr_no]" ).append("\n"); 
		query.append("AND cntr.cnmv_cyc_no = 9999           --DUMMY CYCLE(MT ATTACH, ACTUAL MOVEMENT 없음)" ).append("\n"); 
		query.append("AND cntr.bkg_no      = Bk.bkg_no" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'S'--CANCEL/MEMO SPLIT MASTER 제외" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append(", BKG_VVD VVD" ).append("\n"); 
		query.append("WHERE CNTR.CNTR_NO     = @[cntr_no]    --같은 CNTR" ).append("\n"); 
		query.append("AND CNTR.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("AND CNTR.BKG_NO      = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = 'P'           --EMPTY BKG" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'S'--CANCEL/MEMO SPLIT MASTER 제외" ).append("\n"); 
		query.append("AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD       = substr(@[vvd], 1, 4)      --첫 배가 같음" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD   = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND BK.POL_CD        = @[pol_cd]       --ORIGIN이 같음" ).append("\n"); 
		query.append("AND BK.BKG_NO        <> @[bkg_no] --저장하려는 BKG과 다른 BKG이 있으면 예약" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE CNTR.CNTR_NO     = @[cntr_no]    --같은 CNTR" ).append("\n"); 
		query.append("AND CNTR.BKG_NO      =  BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = 'P'           --EMPTY BKG" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD    <> 'S'--CANCEL/MEMO SPLIT MASTER 제외" ).append("\n"); 
		query.append("AND BK.POL_CD        = @[pol_cd]      --ORIGIN이 같음" ).append("\n"); 
		query.append("AND BK.BKG_NO        <> @[bkg_no]     --저장하려는 BKG과 다른 BKG" ).append("\n"); 
		query.append("AND NVL(CNTR.CGO_RCV_DT, BK.BKG_CRE_DT) > SYSDATE - 7 --금일 기준 -7일 이내에 ATTACH인 게 있으면 예약" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1 --하나라도 있으면 예약" ).append("\n"); 

	}
}