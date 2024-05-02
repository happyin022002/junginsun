/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeDGMNFTCNTRInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.07 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeDGMNFTCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * DGMNFT Cntr make flat file
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeDGMNFTCNTRInfoRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeDGMNFTCNTRInfoRSQL").append("\n");
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
		query.append("SELECT	SUBSTR(" ).append("\n");
		query.append("		MAX(TO_CHAR(CNTR_SEQ, '00000')||" ).append("\n");
		query.append("			CNTR_NO					||'~'||	/*	CNTR NO	*/" ).append("\n");
		query.append("			IMDG_CLSS_CD||IMDG_COMP_GRP_CD			||'~'||	/*	IMO CLASS		*/" ).append("\n");
		query.append("			BL_NO						||'~'||	/*	B/L NO		*/" ).append("\n");
		query.append("			IMDG_UN_NO				||'~'||	/*	UN NO			*/" ).append("\n");
		query.append("			MF_CERTI_NO					||'~'||	/*	MANIFEST REFERENCE NO	*/" ).append("\n");
		query.append("			DECODE(@[io_bnd_cd],'O',SUBSTR(@[certi_seq_no],2),@[ib_seq])||'~'||	/*	MANIFEST REFERENCE SEQ NO	*//* OUTBOUD SEQ 만 INBOUND SEQ로 전송*/" ).append("\n");
		query.append("			''		||'~'||	" ).append("\n");
		query.append("			DECODE(CSTMS_DECL_TP_CD, 'I', '1', 'E', '2', 'T', '3', 'R', '4', '9')	||'~'||	/*	하역작업구분 코드	*/" ).append("\n");
		query.append("			SUBSTR(PRP_SHP_NM, 1, 35)	||'~'||	/*	상품명세1		*/" ).append("\n");
		query.append("			SUBSTR(PRP_SHP_NM, 36, 35)||'~'||	/*	상품명세2	*/" ).append("\n");
		query.append("			NET_WGT	/*	WEIGHT	*/" ).append("\n");
		query.append("			), 7)||'~' EDI_SND_MSG" ).append("\n");
		query.append("FROM	BKG_CSTMS_KR_DG_CGO" ).append("\n");
		query.append("WHERE	VSL_CD		=	SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND		SKD_VOY_NO	=	SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND		SKD_DIR_CD	=	SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND		CNTR_SEQ	=	@[cntr_seq]" ).append("\n");
		query.append("AND     CNTR_NO 	=   @[cntr_no]" ).append("\n");
		query.append("AND		IMDG_UN_NO  =   @[imdg_un_no]" ).append("\n");
		query.append("AND		IMDG_CLSS_CD =  @[imdg_clss_cd]" ).append("\n");
		query.append("AND     BL_NO = @[bl_no]" ).append("\n");
		query.append("#if(${io_bnd_cd}=='I')" ).append("\n");
		query.append("AND POD_CD = @[pod_cd]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('I', 'T')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${io_bnd_cd}=='O')" ).append("\n");
		query.append("AND POL_CD = @[pol_cd]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('E', 'R')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, CNTR_NO, IMDG_UN_NO" ).append("\n");

	}
}