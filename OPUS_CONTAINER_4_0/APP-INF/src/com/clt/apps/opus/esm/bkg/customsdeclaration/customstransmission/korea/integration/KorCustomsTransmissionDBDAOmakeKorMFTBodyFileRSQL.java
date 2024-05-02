/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeKorMFTBodyFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.01 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeKorMFTBodyFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Local Manifest Data로 EDI전송을 위한 Main Flat File을 생성한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeKorMFTBodyFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeKorMFTBodyFileRSQL").append("\n");
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
		query.append("SELECT RPAD(NVL(C.BL_NO,' '),12) BL_NO" ).append("\n");
		query.append(", RPAD(NVL(A.CSTMS_CLR_TP_CD,' '),2) CSTMS_CLR_TP_CD" ).append("\n");
		query.append(", RPAD(NVL(A.CSTMS_DCHG_LOC_WH_CD,' '),10) CSTMS_DCHG_LOC_WH_CD" ).append("\n");
		query.append(", RPAD(DECODE(LENGTH(A.CSTMS_CLR_WH_CD),8,A.CSTMS_CLR_WH_CD,' '),10) CSTMS_CLR_WH_CD" ).append("\n");
		query.append(", NVL(A.BD_TP_CD,' ') BD_TP_CD" ).append("\n");
		query.append(", DECODE(A.CSTMS_CLR_WH_CD,'0000000031','Y','N') TRANS_CHK" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_SEQ_NO A, BKG_VVD B, BKG_BOOKING C" ).append("\n");
		query.append("WHERE B.VSL_CD         =   @[vsl_cd]" ).append("\n");
		query.append("AND B.SKD_VOY_NO     =   @[skd_voy_no]" ).append("\n");
		query.append("AND B.SKD_DIR_CD     =   @[skd_dir_cd]" ).append("\n");
		query.append("AND B.POD_CD         =   @[port_cd]" ).append("\n");
		query.append("AND B.BKG_NO         =   C.BKG_NO" ).append("\n");
		query.append("AND C.BKG_NO         =   A.BKG_NO" ).append("\n");
		query.append("AND A.MF_REF_NO      =   @[mrn_no]" ).append("\n");
		query.append("AND A.MRN_BL_TS_CD   =   'I'" ).append("\n");
		query.append("AND (A.SND_DT IS NULL OR A.SND_DT < A.UPD_DT )" ).append("\n");

	}
}